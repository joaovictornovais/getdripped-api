package br.com.getdripped.getdrippedapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.getdripped.getdrippedapi.entities.Produto;
import br.com.getdripped.getdrippedapi.services.ProdutoService;

@RestController
@RequestMapping("/products")
public class ProdutoController {

	private ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}
	
}
