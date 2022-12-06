package io.quarkus.domain;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.SequenceGenerator;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(name = "USU_SEQ", sequenceName = "USUARIO_SEQ", initialValue = 1, allocationSize = 1)
public class Usuario extends PanacheEntityBase {
	@Id
	//@JsonIgnore
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USU_SEQ")
	private Long idUsuario;
	private String login = "";
	private String senha = "";
	private String nome = "";

	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
	private String cpf = "";
	private String endereco = "";

	
	public Usuario() {
	}


	public Usuario(Long idUsuario, String login, String senha, String nome, LocalDate dataNascimento, String cpf, String endereco) {
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Usuario)) {
			return false;
		}
		Usuario usuario = (Usuario) o;
		return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(login, usuario.login) && Objects.equals(senha, usuario.senha) && Objects.equals(nome, usuario.nome) && Objects.equals(dataNascimento, usuario.dataNascimento) && Objects.equals(cpf, usuario.cpf) && Objects.equals(endereco, usuario.endereco);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, login, senha, nome, dataNascimento, cpf, endereco);
	}
	


	@Override
	public String toString() {
		return "{" +
			" idUsuario='" + getIdUsuario() + "'" +
			", login='" + getLogin() + "'" +
			", senha='" + getSenha() + "'" +
			", nome='" + getNome() + "'" +
			", dataNascimento='" + getDataNascimento() + "'" +
			", cpf='" + getCpf() + "'" +
			", endereco='" + getEndereco() + "'" +
			"}";
	}

}
