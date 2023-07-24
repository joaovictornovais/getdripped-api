package br.com.getdripped.getdrippedapi.entities;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import br.com.getdripped.getdrippedapi.dtos.UsuarioDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(nullable = false)
	public String nome;
	@Column(nullable = false)
	public String sobrenome;
	@Column(nullable = false)
	public String cpf;
	@Column(nullable = false)
	public LocalDate dataDeNascimento;
	@Column(nullable = false)
	public String telefone;
	@Column(nullable = false)
	public String email;
	@Column(nullable = false)
	public String senha;
	
	public Usuario() {}

	public Usuario(Long id, String nome, String sobrenome, String cpf, LocalDate dataDeNascimento, String telefone,
			String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(UsuarioDto usuario) {
		BeanUtils.copyProperties(usuario, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
