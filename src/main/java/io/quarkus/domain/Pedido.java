package io.quarkus.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@SequenceGenerator(name = "PED_SEQ", sequenceName = "PEDIDO_SEQ", initialValue = 1, allocationSize = 1)
public class Pedido extends PanacheEntityBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PED_SEQ")
    @JsonIgnore
    private  Long idPedido;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPedido;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Pagamento pagamento;
    
    
    @ManyToOne
    @JsonIgnore
	@JoinColumn(name="idUsuario")
	private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="idPedido")
	private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Long idPedido, LocalDate dataPedido, Pagamento pagamento, Cliente cliente, Set<ItemPedido> itens) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.itens = itens;
    }


    public Long getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getDataPedido() {
        return this.dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ItemPedido> getItens() {
        return this.itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pedido)) {
            return false;
        }
        Pedido pedido = (Pedido) o;
        return Objects.equals(idPedido, pedido.idPedido) && Objects.equals(dataPedido, pedido.dataPedido) && Objects.equals(pagamento, pedido.pagamento) && Objects.equals(cliente, pedido.cliente) && Objects.equals(itens, pedido.itens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, dataPedido, pagamento, cliente, itens);
    }
    

    @Override
    public String toString() {
        return "{" +
            " idPedido='" + getIdPedido() + "'" +
            ", dataPedido='" + getDataPedido() + "'" +
            ", pagamento='" + getPagamento() + "'" +
            ", cliente='" + getCliente() + "'" +
            ", itens='" + getItens() + "'" +
            "}";
    }


}
