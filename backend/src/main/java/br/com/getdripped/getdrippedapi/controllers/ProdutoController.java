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

import br.com.getdripped.getdrippedapi.dtos.ProdutoDto;
import br.com.getdripped.getdrippedapi.services.ProdutoService;

@RestController
@RequestMapping("/products")
public class ProdutoController {

	private ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public List<ProdutoDto> listarProdutos() {
		return produtoService.listarProdutos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
		if (produtoService.buscarPorId(id) == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
		else 
			return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarPorId(id));
	}
	
	@PostMapping()
	public ResponseEntity<ProdutoDto> criarProduto(@RequestBody ProdutoDto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(produto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarProduto(@PathVariable Long id) {
		if (produtoService.buscarPorId(id) == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não foi encontrado");
		else return ResponseEntity.status(HttpStatus.OK).body(produtoService.deletarProduto(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editarProduto(@PathVariable Long id, @RequestBody ProdutoDto produto) {
		if (produtoService.buscarPorId(id) == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não foi encontrado");
		else return ResponseEntity.status(HttpStatus.OK).body(produtoService.editarProduto(id, produto));
	}
	
}
