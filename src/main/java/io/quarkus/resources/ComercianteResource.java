package io.quarkus.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import io.quarkus.domain.Comerciante;
import io.quarkus.domain.Produto;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("/comerciante")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComercianteResource {

	@GET
	@Path("/login/{usu}/{senha}")
	public boolean login(@PathParam("usu") String usu, @PathParam("senha") String senha) {
        Map<String, Object> params = new HashMap<>();
        params.put("login", usu);
        params.put("senha", senha);
        List<Comerciante> aux =  Comerciante.list("login = :login and senha = :senha", params);
		if(aux.size()>0)
			return true;
		else
			return false;
	}

	@GET
	@Path("/buscaProdutoComerciante/{nome}/{idComerciante}")
	public List<Produto> procurarProdutosComerciante(@PathParam("nome") String nome, @PathParam("idComerciante") Long idComerciante ) {
		Map<String, Object> params = new HashMap<>();
        params.put("nome", nome);
        params.put("idComerciante", idComerciante);
        List<Produto> lista =  Produto.list("nome = :nome and idComerciante = :idComerciante", params);
		return lista;
	}

	@POST
	@Transactional
	@Path("/cadastraProdutoComerciante/{idComerciante}")
	public void cadastrarProdutoComerciante(Produto pro, @PathParam("idComerciante") Long idComerciante) {
		Produto p = new Produto();
		p.setNome(pro.getNome());
		p.setPrecoProduto(pro.getPrecoProduto());
		p.setTipo(pro.getTipo());
		p.setCor(pro.getCor());
		p.setDimensoes(pro.getDimensoes());
		p.setImagem(pro.getImagem());
		p.persist();
		Long id = p.getIdProduto();
		if(id!=null){
			Produto.update("idProduto = "+id+" where idComerciante = ?1", idComerciante);
		}
	}

	@PUT
	@Path("/alteraProdutoComerciante/{idProduto}/{idComerciante}")
	@Transactional
	public void alterarProdutosComerciante(@PathParam("idProduto") Long idProduto, @PathParam("idComerciante") Long idComerciante, Produto pro) {
		Map<String, Object> params = new HashMap<>();
        params.put("idProduto", idProduto);
        params.put("idComerciante", idComerciante);
		PanacheQuery<PanacheEntityBase> prod = Produto.find("idProduto = :idProduto and idComerciante = :idComerciante", params);
		Optional<Produto> produtoOp =  prod.firstResultOptional();
		if (produtoOp.isPresent()) {
			Produto p = produtoOp.get();
			p.setNome(pro.getNome());
			p.setPrecoProduto(pro.getPrecoProduto());
			p.setTipo(pro.getTipo());
			p.setCor(pro.getCor());
			p.setDimensoes(pro.getDimensoes());
			p.persist();
		} else {
			throw new NotFoundException();
		}

	}

	@DELETE
	@Path("/deletaProdutoComerciante/{idProduto}/{idComerciante}")
	@Transactional
	public void excluirProdutosComerciante(@PathParam("idProduto") Long idProduto, @PathParam("idComerciante") Long idComerciante) {
		Map<String, Object> params = new HashMap<>();
        params.put("idProduto", idProduto);
        params.put("idComerciante", idComerciante);
		PanacheQuery<PanacheEntityBase> prod = Produto.find("idProduto = :idProduto and idComerciante = :idComerciante", params);
		Optional<Produto> produtoOp =  prod.firstResultOptional();
		produtoOp.ifPresentOrElse(Produto::delete, () -> {
			throw new NotFoundException();
		});
	}

	@GET
    public List<Comerciante> getAllComerciante() {
        return Comerciante.listAll();
    }

	@POST
	@Transactional
	@Path("/cadastraContaComerciante")
	public void cadastrarProdutoComerciante(Comerciante com) {
		Comerciante c = new Comerciante();
		c.setCnpj(com.getCnpj());
		c.setCpf(com.getCnpj());
		c.setDataNascimento(com.getDataNascimento());
		c.setEndereco(com.getEndereco());
		c.setLogin(com.getLogin());
		c.setNome(com.getNome());
		c.setNomeLoja(com.getNomeLoja());
		c.setRazaoSocial(com.getRazaoSocial());
		c.setSenha(com.getSenha());
		c.persist();
	}

	@PUT
	@Path("/alteraContaComerciante/{idComerciante}")
	@Transactional
	public void alteraContaComerciante(@PathParam("idComerciante") Long idComerciante, Comerciante com) {
		Optional<Comerciante> comercianteOp = Comerciante.findByIdOptional(idComerciante);
		if (comercianteOp.isPresent()) {
			Comerciante c = comercianteOp.get();
			c.setCnpj(com.getCnpj());
			c.setCpf(com.getCnpj());
			c.setDataNascimento(com.getDataNascimento());
			c.setEndereco(com.getEndereco());
			c.setLogin(com.getLogin());
			c.setNome(com.getNome());
			c.setNomeLoja(com.getNomeLoja());
			c.setRazaoSocial(com.getRazaoSocial());
			c.setSenha(com.getSenha());
			c.persist();
		} else {
			throw new NotFoundException();
		}

	}

}
