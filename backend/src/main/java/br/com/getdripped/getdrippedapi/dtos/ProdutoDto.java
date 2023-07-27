package br.com.getdripped.getdrippedapi.dtos;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import br.com.getdripped.getdrippedapi.entities.ItemPedido;
import br.com.getdripped.getdrippedapi.entities.Pedido;
import br.com.getdripped.getdrippedapi.entities.Produto;
import br.com.getdripped.getdrippedapi.enums.Categorias;

public class ProdutoDto {
	
	private Long id;
	private String nome;
	private Double preco;
	private String descricao;
	private String imgUrl;
	private Categorias categoria;
	
	private Set<ItemPedido> items = new HashSet<>();

	public ProdutoDto() {}

	public ProdutoDto(Produto produto) {
		BeanUtils.copyProperties(produto, this);
	}
	
	public Set<Pedido> getPedidos() {
		Set<Pedido> set = new HashSet<>();
		for (ItemPedido x : items) {
			set.add(x.getPedido());
		}
		return set;
	}
	
	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
