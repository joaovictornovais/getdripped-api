package br.com.getdripped.getdrippedapi.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import br.com.getdripped.getdrippedapi.dtos.ProdutoDto;
import br.com.getdripped.getdrippedapi.enums.Categorias;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_products")
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Double preco;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private String imgUrl;
	private Integer categoria;
	
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> items = new HashSet<>();
	
	public Produto() {}
	
	public Produto(Long id, String nome, Double preco, String descricao, String imgUrl, Categorias categoria) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.imgUrl = imgUrl;
		setCategoria(categoria);
	}
	
	public Produto(ProdutoDto produtoDto) {
		BeanUtils.copyProperties(produtoDto, this);
	}
	
	public Categorias getCategoria() {
		return Categorias.valueOf(categoria);
	}

	public void setCategoria(Categorias categoria) {
		if (categoria != null) this.categoria = categoria.getCode();
	}
	
	public Set<Pedido> getPedidos() {
		Set<Pedido> set = new HashSet<>();
		for (ItemPedido x : items) {
			set.add(x.getPedido());
		}
		return set;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
}
