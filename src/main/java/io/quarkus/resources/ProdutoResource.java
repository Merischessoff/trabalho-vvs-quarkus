package io.quarkus.resources;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.domain.Produto;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@GET
    public List<Produto> getAllProdutos() {
        return Produto.listAll();
    }
	
	@GET
	@Path("/buscaProdutoNome/{nome}")
	public List<Produto> procurarProdutos(@PathParam("nome") String nome) {
		List<Produto> lista = Produto.list("nome", nome);
		return lista;
	}

	@GET
	@Path("/buscaProdutoId/{id}")
	public Produto procurarProdutosId(@PathParam("id") Long id) {
		Produto p = Produto.findById(id);
		return p;
	}

	@POST
	@Transactional
	public void cadastrarProdutos(Produto prod) {
		Produto p = new Produto();
		p.setNome(prod.getNome());
		p.setPrecoProduto(prod.getPrecoProduto());
		p.setTipo(prod.getTipo());
		p.setCor(prod.getCor());
		p.setDimensoes(prod.getDimensoes());
		p.setImagem(prod.getImagem());
		p.persist();
	}

	@PUT
	@Path("/alteraProduto/{id}")
	@Transactional
	public void alterarProdutos(@PathParam("id") Long id, Produto prod) {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		if (produtoOp.isPresent()) {
			Produto p = produtoOp.get();
			p.setNome(prod.getNome());
			p.setPrecoProduto(prod.getPrecoProduto());
			p.setTipo(prod.getTipo());
			p.setCor(prod.getCor());
			p.setDimensoes(prod.getDimensoes());
			p.setImagem(prod.getImagem());
			p.persist();
		} else {
			throw new NotFoundException();
		}

	}

	@DELETE
	@Path("/deletaProduto/{id}")
	@Transactional
	public void excluirProdutos(@PathParam("id") Long id) {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		produtoOp.ifPresentOrElse(Produto::delete, () -> {
			throw new NotFoundException();
		});
	}


}
