package io.quarkus.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Comerciante extends Usuario {
    private String cnpj;
    private String razaoSocial;
    private String nomeLoja;

    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Produto (solução a partir da JPA 2)
    @JoinColumn(name = "idComerciante")
    private List<Produto> produtos;

    public Comerciante() {}

    public Comerciante(String cnpj, String razaoSocial, String nomeLoja, List<Produto> produtos) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeLoja = nomeLoja;
        this.produtos = produtos;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Comerciante)) {
            return false;
        }
        Comerciante comerciante = (Comerciante) o;
        return Objects.equals(cnpj, comerciante.cnpj) && Objects.equals(razaoSocial, comerciante.razaoSocial) && Objects.equals(nomeLoja, comerciante.nomeLoja) && Objects.equals(produtos, comerciante.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, razaoSocial, nomeLoja, produtos);
    }


    @Override
    public String toString() {
        return "{" +
            " cnpj='" + getCnpj() + "'" +
            ", razaoSocial='" + getRazaoSocial() + "'" +
            ", nomeLoja='" + getNomeLoja() + "'" +
            ", produtos='" + getProdutos() + "'" +
            "}";
    }

}
