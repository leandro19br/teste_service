package br.com.lcs.projetoinicial.handlers;


import br.com.lcs.projetoinicial.exeption.ObjectNotFound;
import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Leandro on 15/10/20.
 * Entidade para classe veiculo
 */

@Provider
public class ObjectNotFoundHandler implements ExceptionMapper<ObjectNotFound> {

    @Override
    public Response toResponse(ObjectNotFound objectNotFound) {
        return Response.
                status(Response.Status.BAD_REQUEST).
                type(MediaType.APPLICATION_JSON_TYPE).
                entity(new Gson().toJson(objectNotFound.getMessage())).build();
    }
}
