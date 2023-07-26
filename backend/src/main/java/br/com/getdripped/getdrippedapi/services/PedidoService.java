package br.com.getdripped.getdrippedapi.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.getdripped.getdrippedapi.dtos.PedidoDto;
import br.com.getdripped.getdrippedapi.entities.Pedido;
import br.com.getdripped.getdrippedapi.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	private PedidoRepository pedidoRepository;
	
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	@Transactional(readOnly = true)
	public List<PedidoDto> listarPedidos() {
		var pedidos = pedidoRepository.findAll();
		return pedidos.stream().map(x -> new PedidoDto(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public PedidoDto buscarPorId(Long id) {
		var pedido = pedidoRepository.findById(id);
		if (pedido.isEmpty()) return null;
		else return new PedidoDto(pedido.get());
	}
	
	@Transactional
	public PedidoDto criarPedido(PedidoDto pedido) {
		var novoPedido = pedidoRepository.save(new Pedido(pedido));
		return buscarPorId(novoPedido.getId());
	}
	
	@Transactional
	public List<PedidoDto> deletarPedido(Long id) {
		pedidoRepository.deleteById(id);
		return listarPedidos();
	}
	
	public PedidoDto editarPedido(Long id, PedidoDto pedido) {
		var pedidoNovo = new PedidoDto();
		BeanUtils.copyProperties(pedido, pedidoNovo);
		pedidoNovo.setId(id);
		pedidoRepository.save(new Pedido(pedidoNovo));
		return pedidoNovo;
	}

}
