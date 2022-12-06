
package io.quarkus.domain;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


import io.quarkus.hibernate.orm.panache.*;

@Entity
@SequenceGenerator(name = "PRO_SEQ", sequenceName = "PRODUTO_SEQ", initialValue = 1, allocationSize = 1)
public class Produto extends PanacheEntityBase {

	@Id
	//@JsonIgnore
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRO_SEQ")
	private Long idProduto;
	private String nome = "";
	private String tipo = "";
	private double precoProduto = 0;
	private String dimensoes = "";
	private String cor = "";
	private String imagem = "";

	public Produto(){
	}

	public Produto(Long idProduto, String nome, String tipo, double precoProduto, String dimensoes, String cor, String imagem) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.tipo = tipo;
		this.precoProduto = precoProduto;
		this.dimensoes = dimensoes;
		this.cor = cor;
		this.imagem = imagem;
	}

	

	public Long getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecoProduto() {
		return this.precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getDimensoes() {
		return this.dimensoes;
	}

	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getImagem() {
		return this.imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Produto)) {
			return false;
		}
		Produto produto = (Produto) o;
		return Objects.equals(idProduto, produto.idProduto) && Objects.equals(nome, produto.nome) && Objects.equals(tipo, produto.tipo) && precoProduto == produto.precoProduto && Objects.equals(dimensoes, produto.dimensoes) && Objects.equals(cor, produto.cor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduto, nome, tipo, precoProduto, dimensoes, cor);
	}


	@Override
	public String toString() {
		return "{" +
			" idProduto='" + getIdProduto() + "'" +
			", nome='" + getNome() + "'" +
			", tipo='" + getTipo() + "'" +
			", precoProduto='" + getPrecoProduto() + "'" +
			", dimensoes='" + getDimensoes() + "'" +
			", cor='" + getCor() + "'" +
			"}";
	}


}
