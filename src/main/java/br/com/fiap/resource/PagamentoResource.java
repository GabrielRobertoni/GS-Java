package br.com.fiap.resource;

import br.com.fiap.bo.PagamentoBO;
import br.com.fiap.to.PagamentoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.validation.Valid;

@Path("/pagamento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagamentoResource {

    private PagamentoBO bo = new PagamentoBO();

    @GET
    public Response findAll() {
        return Response.ok(bo.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        PagamentoTO pagamento = bo.findById(id);
        if (pagamento == null)
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Pagamento não encontrado.").build();
        return Response.ok(pagamento).build();
    }

    @POST
    public Response create(@Valid PagamentoTO pagamento) {
        PagamentoTO novo = bo.save(pagamento);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid PagamentoTO pagamento) {
        pagamento.setCdPagamento(id);
        PagamentoTO atualizado = bo.update(pagamento);
        if (atualizado != null)
            return Response.ok(atualizado).build();

        return Response.status(Response.Status.NOT_FOUND)
                .entity("Pagamento não encontrado.").build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        boolean apagado = bo.delete(id);
        if (apagado)
            return Response.ok("Pagamento excluído com sucesso.").build();
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Pagamento não encontrado.").build();
    }
}
