package br.com.lcs.projetoinicial.paths;

import br.com.lcs.projetoinicial.anotations.Transactional;
import br.com.lcs.projetoinicial.exeption.ObjectNotFound;
import br.com.lcs.projetoinicial.persistence.dao.Dao;
import br.com.lcs.projetoinicial.persistence.model.Veiculo;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

@Path("/veiculo")
public class CarrosPath {

    private List<Veiculo> veiculos;
    @Inject
    private Dao<Veiculo> dao;

    @GET
    @Path("oi")
    @Produces("application/json")
    public Response oi() {
        return Response.ok(new Gson().toJson("funcionou")).build();
    }

    @GET
    @Path("listar")
    @Produces("application/json")
    public Response listar() {

       this.veiculos =  dao.listAll();
        return Response.ok(new Gson().toJson(veiculos)).build();

    }

    @GET
    @Path("buscar/{nome}")
    @Produces("application/json")
    public Response buscar(@PathParam("nome") String veiculo) throws ObjectNotFound {

        this.veiculos = dao.findByHqlQyery("findVeiculoByName", Collections.singletonList(veiculo), 0);
       return Response.ok(new Gson().toJson(veiculos)).build();
    }

    @POST
    @Path("salvar")
    @Produces("application/json")
    @Consumes("application/json")
    @Transactional
    public Response salvar(Veiculo veiculo)  {
        Veiculo veiculoSave = dao.save(veiculo);
        System.out.println(veiculo.getMarca());
        return Response.ok(new Gson().toJson(veiculoSave)).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    @Transactional
    public Response deletar(@PathParam("id") int id)  {
        Veiculo byId = dao.findById(id);
        dao.remove(byId);
        return Response.ok(new Gson().toJson("veiculo deletado com sucesso" + byId)).build();
    }

    @PUT
    @Path("editar/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    @Transactional
    public Response editar(@PathParam("id") int id,Veiculo veiculo)  {
        Veiculo byId = dao.findById(id);
        if (byId.equals(null)){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Veiculo veiculoAtualizado = dao.update(veiculo);
        System.out.println(veiculo.getMarca());
        return Response.ok(new Gson().toJson(veiculoAtualizado)).build();
    }
}
