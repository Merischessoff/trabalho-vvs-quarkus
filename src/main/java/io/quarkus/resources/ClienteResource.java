package io.quarkus.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.domain.Cliente;
import io.quarkus.domain.Comerciante;
import io.quarkus.domain.Produto;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

	@GET
	@Path("/login/{usu}/{senha}")
	public boolean login(@PathParam("usu") String usu, @PathParam("senha") String senha) {
		Map<String, Object> params = new HashMap<>();
		params.put("login", usu);
		params.put("senha", senha);
		List<Cliente> aux = Cliente.list("login = :login and senha = :senha", params);
		if (aux.size() > 0)
			return true;
		else
			return false;
	}

	@GET
	@Path("/buscaClienteProduto/{nome}")
	public List<Produto> pesquisarProdutos(@PathParam("nome") String nome) {
		List<Produto> lista = Produto.list("nome", nome);
		return lista;
	}

	@GET
	@Path("/buscaLoja/loja/{nome}")
	public List<Comerciante> pesquisarLoja(@PathParam("nome") String nome) {
		List<Comerciante> lista = Comerciante.list("nomeLoja", nome);
		return lista;
	}

	@PUT
	@Path("/alteraCliente/{id}")
	@Transactional
	public boolean alteraDadosCliente(@PathParam("id") Long id, Cliente usu) {
		Optional<Cliente> clienteOp = Cliente.findByIdOptional(id);
		boolean retorno = false;
		if (clienteOp.isPresent()) {
			Cliente u = clienteOp.get();
			u.setDataNascimento(usu.getDataNascimento());
			u.setEndereco(usu.getEndereco());
			u.setLogin(usu.getLogin());
			u.setNome(usu.getNome());
			u.setSenha(usu.getSenha());
			u.persist();
			retorno = true;
		}
		return retorno;

	}

	@GET
	public List<Cliente> getAllClientes() {
		List<Cliente> list = Cliente.listAll();
		return list;
	}
}
