package br.com.getdripped.getdrippedapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProdutoController {

	@GetMapping
	public String index() {
		return "Hello, world";
	}
	
}
