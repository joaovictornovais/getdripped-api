package br.com.getdripped.getdrippedapi.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.getdripped.getdrippedapi.dtos.UsuarioDto;
import br.com.getdripped.getdrippedapi.entities.Usuario;
import br.com.getdripped.getdrippedapi.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Transactional(readOnly = true)
	public List<UsuarioDto> listarUsuarios() {
		var usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(x -> new UsuarioDto(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public UsuarioDto buscarPorId(Long id) {
		var usuario = usuarioRepository.findById(id);
		if (usuario.isEmpty()) return null;
		else return new UsuarioDto(usuario.get());
	}
	
	@Transactional
	public UsuarioDto criarUsuario(UsuarioDto usuario) {
		var novoUsuario = usuarioRepository.save(new Usuario(usuario));
		return buscarPorId(novoUsuario.getId());
	}
	
	@Transactional
	public List<UsuarioDto> deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
		return listarUsuarios();
	}
	
	@Transactional
	public UsuarioDto editarUsuario(Long id, UsuarioDto usuario) {
		var usuarioNovo = new UsuarioDto();
		BeanUtils.copyProperties(usuario, usuarioNovo);
		usuarioNovo.setId(id);
		usuarioRepository.save(new Usuario(usuarioNovo));
		return usuarioNovo;
	}
}