package br.com.getdripped.getdrippedapi.entities;

import java.time.Instant;

import org.springframework.beans.BeanUtils;

import br.com.getdripped.getdrippedapi.dtos.PedidoDto;
import br.com.getdripped.getdrippedapi.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_orders")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private StatusPedido statusPedido;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Usuario cliente;
	
	
	public Pedido() {}

	public Pedido(Long id, Instant momento, StatusPedido statusPedido, Usuario cliente) {
		this.id = id;
		this.momento = momento;
		this.statusPedido = statusPedido;
		this.cliente = cliente;
	}
	
	public Pedido(PedidoDto pedidoDto) {
		BeanUtils.copyProperties(pedidoDto, this);
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
}
