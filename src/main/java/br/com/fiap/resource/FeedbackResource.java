package br.com.fiap.resource;

import br.com.fiap.bo.FeedbackBO;
import br.com.fiap.to.FeedbackTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.ArrayList;

@Path("/feedback")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedbackResource {

    private FeedbackBO bo = new FeedbackBO();

    @GET
    public Response listar() {
        ArrayList<FeedbackTO> lista = bo.findAll();
        if (lista.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).entity("Nenhum feedback encontrado.").build();
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        FeedbackTO f = bo.findById(id);
        if (f == null)
            return Response.status(Response.Status.NOT_FOUND).entity("Feedback não encontrado.").build();
        return Response.ok(f).build();
    }

    @POST
    public Response cadastrar(@Valid FeedbackTO f) {
        FeedbackTO novo = bo.save(f);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid FeedbackTO f) {
        f.setCdFeedback(id);
        FeedbackTO atualizado = bo.update(f);
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        if (bo.delete(id))
            return Response.status(Response.Status.NO_CONTENT).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Feedback não encontrado.").build();
    }
}
