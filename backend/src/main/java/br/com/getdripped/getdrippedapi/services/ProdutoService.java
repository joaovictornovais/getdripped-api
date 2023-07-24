package br.com.getdripped.getdrippedapi.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.getdripped.getdrippedapi.dtos.ProdutoDto;
import br.com.getdripped.getdrippedapi.entities.Produto;
import br.com.getdripped.getdrippedapi.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Transactional(readOnly = true)
	public List<ProdutoDto> listarProdutos() {
		var produtos = produtoRepository.findAll();
		return produtos.stream().map(x -> new ProdutoDto(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public ProdutoDto buscarPorId(Long id) {
		var produto = produtoRepository.findById(id);
		if (produto.isEmpty()) return null;
		else return new ProdutoDto(produto.get());
	}
	
	@Transactional
	public ProdutoDto criarProduto(ProdutoDto produto) {
		var novoProduto = produtoRepository.save(new Produto(produto));
		return buscarPorId(novoProduto.getId());
	}
	
	@Transactional
	public List<ProdutoDto> deletarProduto(Long id) {
		produtoRepository.deleteById(id);
		return listarProdutos();
	}
	
	public ProdutoDto editarProduto(Long id, ProdutoDto produto) {
		var produtoNovo = new ProdutoDto();
		BeanUtils.copyProperties(produto, produtoNovo);
		produtoNovo.setId(id);
		produtoRepository.save(new Produto(produtoNovo));
		return produtoNovo;
	}

}
