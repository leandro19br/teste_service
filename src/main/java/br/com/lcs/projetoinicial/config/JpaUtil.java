package br.com.lcs.projetoinicial.config;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Leandro on 15/10/20.
 * Entidade para classe veiculo
 */


public class JpaUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    @Produces
    @RequestScoped
    public EntityManager criarEntityManager() {
        return emf.createEntityManager();

    }

    public void fecharEntityManager(@Disposes EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }

    }

}
