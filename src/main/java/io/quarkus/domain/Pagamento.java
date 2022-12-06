package io.quarkus.domain;


import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@SequenceGenerator(name = "PAG_SEQ", sequenceName = "PAGAMENTO_SEQ", initialValue = 1, allocationSize = 1)
public class Pagamento extends PanacheEntityBase {
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAG_SEQ")
    //@JsonIgnore
    private Long idPagamento;
    private String estado;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPagamento;

    private Integer numerosDeParcelas;

    private String tipoPagamento;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Pedido pedido;

    public Pagamento() {}

    public String getTipoPagamento() {
        return tipoPagamento;
    }


    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }


    public Long getIdPagamento() {
        return this.idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Integer getNumerosDeParcelas() {
        return this.numerosDeParcelas;
    }

    public void setNumerosDeParcelas(Integer numerosDeParcelas) {
        this.numerosDeParcelas = numerosDeParcelas;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pagamento)) {
            return false;
        }
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(idPagamento, pagamento.idPagamento) && Objects.equals(estado, pagamento.estado) && Objects.equals(dataVencimento, pagamento.dataVencimento) && Objects.equals(dataPagamento, pagamento.dataPagamento) && Objects.equals(numerosDeParcelas, pagamento.numerosDeParcelas) && Objects.equals(tipoPagamento, pagamento.tipoPagamento) && Objects.equals(pedido, pagamento.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPagamento, estado, dataVencimento, dataPagamento, numerosDeParcelas, tipoPagamento, pedido);
    }


    @Override
    public String toString() {
        return "{" +
            " idPagamento='" + getIdPagamento() + "'" +
            ", estado='" + getEstado() + "'" +
            ", dataVencimento='" + getDataVencimento() + "'" +
            ", dataPagamento='" + getDataPagamento() + "'" +
            ", numerosDeParcelas='" + getNumerosDeParcelas() + "'" +
            ", tipoPagamento='" + getTipoPagamento() + "'" +
            ", pedido='" + getPedido() + "'" +
            "}";
    }


}
