package io.quarkus.builder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import io.quarkus.domain.Cliente;
import io.quarkus.domain.ItemPedido;
import io.quarkus.domain.Pagamento;
import io.quarkus.domain.Pedido;
import io.quarkus.domain.Produto;

public class PedidoBuilder {
    private Pedido pedido;
	private Cliente cliente;
    private Pagamento pagamento;
    private Set<ItemPedido> itens = new HashSet<>();

    public PedidoBuilder() {
        this.pedido = new Pedido();
        this.cliente = new Cliente();
        this.pagamento = new Pagamento();
    }
    public static PedidoBuilder builder() {
        return new PedidoBuilder();
    }
    public PedidoBuilder addDataPedido(LocalDate data) {
        this.pedido.setDataPedido(data);
        return this;
    }
    public PedidoBuilder addPedidoPagamento() {
        this.pedido.setPagamento(pagamento);
        return this;
    }

    public PedidoBuilder addItem(Integer quantidade, Double preco, Produto p) {
        ItemPedido item = new ItemPedido();
        item.setProduto(p);
        item.setQuantidade(quantidade);
        item.setPreco(preco);
        item.setPedido(this.pedido);
        this.itens.add(item);
        return this;
    }
    
    public PedidoBuilder addPedidoItens() {
        this.pedido.setItens(itens);
        return this;
    }
    public PedidoBuilder addDataPedidoPagamento() {
        this.pedido.setPagamento(pagamento);
        return this;
    }
    public PedidoBuilder addClienteCpf(String cpf) {
        this.cliente.setCpf(cpf);
        return this;
    }
    public PedidoBuilder addClienteDataNas(LocalDate dataNascimento) {
        this.cliente.setDataNascimento(dataNascimento);
        return this;
    }
    public PedidoBuilder addClienteLogin(String login) {
        this.cliente.setLogin(login);
        return this;
    }
    public PedidoBuilder addClienteSenha(String senha) {
        this.cliente.setSenha(senha);
        return this;
    }
    public PedidoBuilder addClienteNome(String nome) {
        this.cliente.setNome(nome);
        return this;
    }
    public PedidoBuilder addClienteEndereco(String endereco){
        this.cliente.setEndereco(endereco);
        return this;
    }
    public PedidoBuilder addPagamentoDataPagamento(LocalDate dataPagamento){
        this.pagamento.setDataPagamento(dataPagamento);
        return this;
    }
    public PedidoBuilder addPagamentoDataVencimento(LocalDate dataVencimento){
        this.pagamento.setDataVencimento(dataVencimento);
        return this;
    }
    public PedidoBuilder addPagamentoEstado(String estado){
        this.pagamento.setEstado(estado);
        return this;
    }
    public PedidoBuilder addPagamentoNumeroParcelas(Integer numerosDeParcelas){
        this.pagamento.setNumerosDeParcelas(numerosDeParcelas);
        return this;
    }
    public PedidoBuilder addPagamentoTipo(String tipoPagamento){
        this.pagamento.setTipoPagamento(tipoPagamento);
        return this;
    }
    public PedidoBuilder addPagamentoPedido(){
        this.pagamento.setPedido(this.pedido);
        return this;
    }

    public Pedido getPedido(){
        return this.pedido;
    }
    
}
