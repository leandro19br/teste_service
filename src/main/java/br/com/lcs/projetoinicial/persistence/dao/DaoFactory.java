package br.com.lcs.projetoinicial.persistence.dao;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Leandro on 15/10/20.
 * Classe para criar o DaoImpl através da injeção de dependencia
 */
public class DaoFactory {
    @Inject
    private EntityManager em;

    @SuppressWarnings({"rawtypes,unchecked"})
    @Produces
    @Dependent
    public <T>Dao<T> createDAO(InjectionPoint point){
         ParameterizedType type  = (ParameterizedType) point.getType();
         Class classes = (Class) type.getActualTypeArguments()[0];
         return new DaoImpl<T>(classes,em);
    }
}
