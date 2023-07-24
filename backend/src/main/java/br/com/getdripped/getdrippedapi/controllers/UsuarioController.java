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

import br.com.getdripped.getdrippedapi.dtos.UsuarioDto;
import br.com.getdripped.getdrippedapi.services.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioSerivce) {
		this.usuarioService = usuarioSerivce;
	}
	
	@GetMapping
	public List<UsuarioDto> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
		if (usuarioService.buscarPorId(id) == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		else 
			return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarPorId(id));
	}
	
	@PostMapping()
	public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody UsuarioDto usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(usuario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarUsuario(@PathVariable Long id) {
		if (usuarioService.buscarPorId(id) == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não foi encontrado");
		else return ResponseEntity.status(HttpStatus.OK).body(usuarioService.deletarUsuario(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editarUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuario) {
		if (usuarioService.buscarPorId(id) == null) 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não foi encontrado");
		else return ResponseEntity.status(HttpStatus.OK).body(usuarioService.editarUsuario(id, usuario));
	}

}
