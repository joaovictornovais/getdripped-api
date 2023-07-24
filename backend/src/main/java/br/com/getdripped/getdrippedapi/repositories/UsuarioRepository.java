package br.com.getdripped.getdrippedapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.getdripped.getdrippedapi.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
