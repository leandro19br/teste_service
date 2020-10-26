package br.com.lcs.projetoinicial.persistence.dao;


import br.com.lcs.projetoinicial.persistence.enums.Condition;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Dao<T> extends Serializable {


    T save(T entity);

    T update(T entity);

    T findById(Serializable id);

    void remove(T entity);

    List<T> listAll();

    List<T> findByHqlQyery(String queryId, int maxResults);

    List<T> findByHqlQyery(String queryId, List<Object> params, int maxResults);

    List<T> findByHqlQyery(Map<String, Object> mapAttributValues, List<Condition> conditions);
}
