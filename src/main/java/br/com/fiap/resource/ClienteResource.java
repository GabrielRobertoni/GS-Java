package br.com.fiap.resource;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.to.ClienteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    private ClienteBO bo = new ClienteBO();

    @GET
    public Response listar() {
        ArrayList<ClienteTO> lista = bo.findAll();
        if (lista == null || lista.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Nenhum cliente encontrado.").build();
        }
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        ClienteTO cliente = bo.findById(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado.").build();
        }
        return Response.ok(cliente).build();
    }

    @POST
    public Response cadastrar(@Valid ClienteTO cliente) {
        ClienteTO novo = bo.save(cliente);
        if (novo != null) return Response.status(Response.Status.CREATED).entity(novo).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao criar cliente").build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid ClienteTO cliente) {
        cliente.setCdCliente(id);
        ClienteTO atualizado = bo.update(cliente);
        if (atualizado != null) return Response.ok(atualizado).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado para atualização.").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean removido = bo.delete(id);
        if (!removido)
            return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado.").build();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
