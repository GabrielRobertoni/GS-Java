package br.com.fiap.resource;

import br.com.fiap.bo.ServicoBO;
import br.com.fiap.to.ServicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/servico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicoResource {

    private ServicoBO bo = new ServicoBO();

    @GET
    public Response findAll() {
        List<ServicoTO> lista = bo.findAll();
        if (lista == null || lista.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Nenhum serviço encontrado.").build();
        }
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        ServicoTO servico = bo.findById(id);
        if (servico != null) return Response.ok(servico).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Serviço não encontrado.").build();
    }

    @POST
    public Response save(@Valid ServicoTO servico) {
        ServicoTO novo = bo.save(servico);
        if (novo != null) return Response.status(Response.Status.CREATED).entity(novo).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao salvar serviço.").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid ServicoTO servico) {
        servico.setCdServico(id);
        ServicoTO atualizado = bo.update(servico);
        if (atualizado != null) return Response.ok(atualizado).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Serviço não encontrado para atualização.").build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (bo.delete(id)) return Response.status(Response.Status.NO_CONTENT).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Serviço não encontrado para exclusão.").build();
    }
}
