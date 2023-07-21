package br.com.getdripped.getdrippedapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.getdripped.getdrippedapi.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
