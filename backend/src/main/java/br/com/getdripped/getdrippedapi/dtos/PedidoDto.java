package br.com.getdripped.getdrippedapi.dtos;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import br.com.getdripped.getdrippedapi.entities.ItemPedido;
import br.com.getdripped.getdrippedapi.entities.Pedido;
import br.com.getdripped.getdrippedapi.entities.Usuario;
import br.com.getdripped.getdrippedapi.enums.StatusPedido;

public class PedidoDto {

	private Long id;
	private Instant momento;
	private StatusPedido statusPedido;
	private Usuario cliente;
	
	private Set<ItemPedidoDto> items = new HashSet<>();
	
	public PedidoDto() {}

	public PedidoDto(Long id, Instant momento, StatusPedido statusPedido, Usuario cliente) {
		this.id = id;
		this.momento = momento;
		this.statusPedido = statusPedido;
		this.cliente = cliente;
	}
	
	public PedidoDto(Pedido pedido) {
		BeanUtils.copyProperties(pedido, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	public Set<ItemPedidoDto> getItems() {
		return items;
	}
}
