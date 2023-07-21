package br.com.getdripped.getdrippedapi.dtos;

import org.springframework.beans.BeanUtils;

import br.com.getdripped.getdrippedapi.entities.Produto;

public class ProdutoDto {
	
	private Long id;
	private String nome;
	private Double preco;
	private String description;
	private String imgUrl;
	
	public ProdutoDto() {}

	public ProdutoDto(Produto produto) {
		BeanUtils.copyProperties(produto, this);
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
