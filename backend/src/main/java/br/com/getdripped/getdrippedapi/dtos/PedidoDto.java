package br.com.getdripped.getdrippedapi.dtos;

import java.time.Instant;

import org.springframework.beans.BeanUtils;

import br.com.getdripped.getdrippedapi.entities.Pedido;
import br.com.getdripped.getdrippedapi.entities.Usuario;

public class PedidoDto {

	private Long id;
	private Instant momento;
	private Usuario cliente;
	
	public PedidoDto() {}

	public PedidoDto(Long id, Instant momento, Usuario cliente) {
		this.id = id;
		this.momento = momento;
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

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
}
