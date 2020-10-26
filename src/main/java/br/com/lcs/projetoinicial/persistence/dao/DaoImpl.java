package br.com.lcs.projetoinicial.persistence.dao;

import br.com.lcs.projetoinicial.persistence.enums.Condition;
import br.com.lcs.projetoinicial.persistence.fileservice.FileXmlService;
import com.google.gson.internal.$Gson$Preconditions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaoImpl<T> implements Dao<T> {

    @PersistenceContext
    private EntityManager em;
    private final Class<T> classe;
    private static final FileXmlService hqlQuery;
    private static final FileXmlService sqlQuery;

    static {
        hqlQuery = new FileXmlService("hql.xml");
        sqlQuery = new FileXmlService("sql.xml");
    }

    public DaoImpl(Class<T> classe, EntityManager em) {
        this.classe = classe;
        this.em = em;
    }

    @Override
    public T save(T entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

    @Override
    public T update(T entity) {
        em.merge(entity);
        em.flush();
        return entity;
    }

    @Override
    public T findById(Serializable id) {
        return em.find(this.classe,id);
    }

    @Override
    public void remove(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        em.flush();
    }

    @Override
    public List<T> listAll() {
        StringBuilder sql = new StringBuilder(60);
        sql.append("select v from ").append(this.classe.getSimpleName()).append(" v ");
        TypedQuery<T> query = em.createQuery(sql.toString(), this.classe);
        return query.getResultList();
    }

    @Override
    public List<T> findByHqlQyery(String queryId, int maxResults) {
        String hql = hqlQuery.findValue(queryId);
        TypedQuery<T> query = em.createQuery(hql.toString(), this.classe);
        return maxResults == 0 ? query.getResultList() : query.setMaxResults(maxResults).getResultList();
    }

    @Override
    public List<T> findByHqlQyery(String queryId, List<Object> params, int maxResults) {
        String hql = hqlQuery.findValue(queryId);
        Pattern pattern = Pattern.compile("(:\\w+)");
        Matcher matcher = pattern.matcher(hql);
        List<String> values = new ArrayList<>();
        while (matcher.find()) {
            values.add(matcher.group().replace(":", ""));
        }
        TypedQuery<T> query = em.createQuery(hql, this.classe);
        for (int i = 0; i < values.size(); i++) {
            query.setParameter(values.get(i), params.get(i));
        }

        return maxResults == 0 ? query.getResultList() : query.setMaxResults(maxResults).getResultList();
    }

    @Override
    public List<T> findByHqlQyery(Map<String, Object> mapAttributValues , List<Condition> conditions) {

        StringBuilder hql = new StringBuilder(80);
        hql.append("select e from ").append(this.classe.getSimpleName()).append("e");
        int i = 0;
        for (Map.Entry<String, Object> entry : mapAttributValues.entrySet()){
            if (i == 0){
                hql.append(" WHERE e. ").append(entry.getKey()).append(" ").append(conditions.get(i).getCondition())
                        .append(" :value").append(i);
            }else {
                hql.append(" AND e. ").append(entry.getKey()).append(" ").append(conditions.get(i).getCondition())
                        .append(" :value").append(i);
                i++;
            }
        }

        i = 0;
       TypedQuery<T> query = em.createQuery(hql.toString(), this.classe);
        for (Map.Entry<String, Object> entry : mapAttributValues.entrySet()){
            query.setParameter("values" + i, entry.getValue());
            i++;
        }
        return query.getResultList();
    }


}
