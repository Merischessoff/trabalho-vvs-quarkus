package io.quarkus.domain;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class ItemPedido extends PanacheEntityBase implements Serializable{
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	@JsonIgnore
	private Integer quantidade;
	
	@JsonIgnore
	private Double preco;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
	private Pedido pedido;
	
	public ItemPedido() {
	}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ItemPedido)) {
			return false;
		}
		ItemPedido itemPedido = (ItemPedido) o;
		return Objects.equals(id, itemPedido.id) && Objects.equals(quantidade, itemPedido.quantidade) && Objects.equals(preco, itemPedido.preco) && Objects.equals(pedido, itemPedido.pedido);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, quantidade, preco, pedido);
	}
	

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", quantidade='" + getQuantidade() + "'" +
			", preco='" + getPreco() + "'" +
			", pedido='" + getPedido() + "'" +
			"}";
	}


}