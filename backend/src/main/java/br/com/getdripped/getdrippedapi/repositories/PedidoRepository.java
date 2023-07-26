package br.com.getdripped.getdrippedapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.getdripped.getdrippedapi.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
