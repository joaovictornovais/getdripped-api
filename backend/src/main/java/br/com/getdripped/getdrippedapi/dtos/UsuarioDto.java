package br.com.getdripped.getdrippedapi.dtos;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import br.com.getdripped.getdrippedapi.entities.Usuario;

public class UsuarioDto {

	public Long id;
	public String nome;
	public String sobrenome;
	public String cpf;
	public LocalDate dataDeNascimento;
	public String telefone;
	public String email;
	public String senha;
	
	public UsuarioDto() {}

	public UsuarioDto(Usuario usuario) {
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
