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
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(x -> new UsuarioDto(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public UsuarioDto buscarPorId(Long id) {
		var optionalUsuario = usuarioRepository.findById(id);
		if (optionalUsuario.isEmpty()) return null;
		else return new UsuarioDto(optionalUsuario.get());
	}
	
	@Transactional
	public UsuarioDto criarUsuario(UsuarioDto usuario) {
		var novoProduto = usuarioRepository.save(new Usuario(usuario));
		return buscarPorId(novoProduto.getId());
	}
	
	@Transactional
	public List<UsuarioDto> deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
		return listarUsuarios();
	}
	
	@Transactional
	public UsuarioDto editarUsuario(UsuarioDto usuario, Long id) {
		var usuarioNovo = new UsuarioDto();
		BeanUtils.copyProperties(usuario, usuarioNovo);
		usuarioNovo.setId(id);
		usuarioRepository.save(new Usuario(usuarioNovo));
		return usuarioNovo;
	}
}