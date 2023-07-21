package br.com.getdripped.getdrippedapi.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.getdripped.getdrippedapi.entities.Produto;
import br.com.getdripped.getdrippedapi.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Transactional(readOnly = true)
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

}
