package br.com.lcs.projetoinicial.anotations;

import javax.interceptor.InterceptorBinding;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional  {


}
