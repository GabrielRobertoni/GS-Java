package br.com.fiap.resource;

import br.com.fiap.bo.SeguroBO;
import br.com.fiap.to.SeguroTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.ArrayList;

@Path("/seguro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SeguroResource {

    private SeguroBO bo = new SeguroBO();

    @GET
    public Response listar() {
        ArrayList<SeguroTO> lista = bo.findAll();
        if (lista.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Nenhum seguro encontrado.").build();
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        SeguroTO s = bo.findById(id);
        if (s == null)
            return Response.status(Response.Status.NOT_FOUND).entity("Seguro não encontrado.").build();
        return Response.ok(s).build();
    }

    @POST
    public Response cadastrar(@Valid SeguroTO s) {
        SeguroTO novo = bo.save(s);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid SeguroTO s) {
        s.setCdApolice(id);
        SeguroTO atualizado = bo.update(s);
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        if (bo.delete(id))
            return Response.status(Response.Status.NO_CONTENT).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Seguro não encontrado.").build();
    }
}
