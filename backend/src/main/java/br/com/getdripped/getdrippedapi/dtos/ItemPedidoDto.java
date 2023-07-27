package br.com.getdripped.getdrippedapi.dtos;

import br.com.getdripped.getdrippedapi.entities.Pedido;
import br.com.getdripped.getdrippedapi.entities.Produto;
import br.com.getdripped.getdrippedapi.entities.pk.ItemPedidoPK;

public class ItemPedidoDto {
	
	private ItemPedidoPK id = new ItemPedidoPK();
	private Integer quantidade;
	private Double preco;
	
	public ItemPedidoDto() {}

	public ItemPedidoDto(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}	
}
