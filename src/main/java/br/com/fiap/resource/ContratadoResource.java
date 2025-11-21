package br.com.fiap.resource;

import br.com.fiap.bo.ContratadoBO;
import br.com.fiap.to.ContratadoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/contratado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratadoResource {

    private ContratadoBO bo = new ContratadoBO();

    @GET
    public Response findAll() {
        List<ContratadoTO> lista = bo.findAll();
        if (lista == null || lista.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Nenhum contratado encontrado.").build();
        }
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        ContratadoTO contratado = bo.findById(id);
        if (contratado != null) return Response.ok(contratado).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Contratado não encontrado.").build();
    }

    @POST
    public Response save(@Valid ContratadoTO contratado) {
        ContratadoTO novo = bo.save(contratado);
        if (novo != null) return Response.status(Response.Status.CREATED).entity(novo).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao salvar contratado.").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid ContratadoTO contratado) {
        contratado.setCdContratado(id);
        ContratadoTO atualizado = bo.update(contratado);
        if (atualizado != null) return Response.ok(atualizado).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Contratado não encontrado para atualização.").build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (bo.delete(id)) return Response.status(Response.Status.NO_CONTENT).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Contratado não encontrado para exclusão.").build();
    }
}
