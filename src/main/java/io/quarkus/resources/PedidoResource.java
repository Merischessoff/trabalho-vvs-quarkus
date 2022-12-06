package io.quarkus.resources;

import io.quarkus.builder.PedidoBuilder;
import io.quarkus.domain.Cliente;
import io.quarkus.domain.ItemPedido;
import io.quarkus.domain.Pagamento;
import io.quarkus.domain.Pedido;
import io.quarkus.domain.Produto;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @GET
	@Path("/buscaPedido/{id}")
	public List<Pedido> procurarPedidos(@PathParam("id") Long id) {
		List<Pedido> lista = Pedido.findById(id);
		return lista;
	}

    @GET
	public List<Pedido> getAllPedidos() {
		List<Pedido> lista = Pedido.listAll();
		return lista;
	}

    @DELETE
	@Path("/deletaPedido/{id}")
	@Transactional
	public void excluirPedidos(@PathParam("id") Long id) {
		Optional<Pedido> pedidoOp = Pedido.findByIdOptional(id);
		pedidoOp.ifPresentOrElse(Pedido::delete, () -> {
			throw new NotFoundException();
		});
	}

    @POST
    @Path("/{idCliente}")
	@Transactional
	public void cadastrarPedidos(@PathParam("idCliente") Long idCliente, Pedido obj) {
        Pedido p = new Pedido();
		Pagamento pagto = new Pagamento();
		pagto.setDataPagamento(LocalDate.now());
		pagto.setDataVencimento(LocalDate.now());
		pagto.setEstado("");
		pagto.setNumerosDeParcelas(0);
		pagto.setTipoPagamento("");
		pagto.setPedido(p);
		p.setDataPedido(obj.getDataPedido());		
        p.setPagamento(pagto);
        p.setCliente(Cliente.findById(idCliente));
        p.persist();

		for (ItemPedido ip : obj.getItens()) {
			Produto prod = Produto.findById(ip.getProduto().getIdProduto());
			ip.setProduto(prod);
			ip.setPreco(prod.getPrecoProduto());
            ip.setQuantidade(1);
			ip.setPedido(p);
            ip.persist();
		}
	}

	@POST
    @Path("cadastrarPedidosBuider/{idCliente}")
	@Transactional
	public void cadastrarPedidosBuilder(@PathParam("idCliente") Long idCliente, Pedido obj) {
		Cliente c = Cliente.findById(idCliente);
        Pedido p = PedidoBuilder.builder()
			.addDataPedido(obj.getDataPedido())
			.addPagamentoDataPagamento(LocalDate.now())
			.addPagamentoDataVencimento(LocalDate.now().plusDays(30))
			.addPagamentoEstado("")
			.addPagamentoNumeroParcelas(0)
			.addPagamentoTipo("")
			.addPagamentoPedido()
			.addPedidoPagamento()
			.addClienteCpf(c.getCpf())
			.addClienteDataNas(c.getDataNascimento())
			.addClienteEndereco(c.getEndereco())
			.addClienteLogin(c.getLogin())
			.addClienteNome(c.getNome())
			.addClienteSenha(c.getSenha()).getPedido();

		Set<ItemPedido> itens = new HashSet<>();
		for (ItemPedido ip : obj.getItens()) {
			Produto prod = Produto.findById(ip.getProduto().getIdProduto());
			ip.setProduto(prod);
			ip.setPreco(prod.getPrecoProduto());
            ip.setQuantidade(1);
			ip.setPedido(p);
			itens.add(ip);
		}
		p.setItens(itens);
		p.persist();
	}

}
