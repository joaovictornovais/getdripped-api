package br.com.getdripped.getdrippedapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.getdripped.getdrippedapi.dtos.PedidoDto;
import br.com.getdripped.getdrippedapi.services.PedidoService;

@RestController
@RequestMapping("/orders")
public class PedidoController {

	private PedidoService pedidoService;
	
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping
	public List<PedidoDto> listarPedidos() {
		return pedidoService.listarPedidos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
		if (pedidoService.buscarPorId(id) == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
		else 
			return ResponseEntity.status(HttpStatus.OK).body(pedidoService.buscarPorId(id));
	}
	
	@PostMapping()
	public ResponseEntity<PedidoDto> criarPedido(@RequestBody PedidoDto pedido) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.criarPedido(pedido));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarPedido(@PathVariable Long id) {
		if (pedidoService.buscarPorId(id) == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não foi encontrado");
		else return ResponseEntity.status(HttpStatus.OK).body(pedidoService.deletarPedido(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editarPedido(@PathVariable Long id, @RequestBody PedidoDto pedido) {
		if (pedidoService.buscarPorId(id) == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não foi encontrado");
		else return ResponseEntity.status(HttpStatus.OK).body(pedidoService.editarPedido(id, pedido));
	}
	
}
