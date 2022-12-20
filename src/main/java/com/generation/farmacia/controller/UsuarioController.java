package com.generation.farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.model.Usuario;
import com.generation.farmacia.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List <Usuario> listaUsuarios() {
		return (List <Usuario>) usuarioRepository.findAll();
	}
	
	@PostMapping
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNovo = usuarioRepository.save(usuario);
			return usuarioNovo;
	}
	
	@PutMapping
	public Usuario editarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNovo = usuarioRepository.save(usuario);
			return usuarioNovo;
	} 
	
	@DeleteMapping ("/{id}")
	public Optional<Usuario> excluirUsuario(@PathVariable Long id) {
		Optional<Usuario> usuarioDel = usuarioRepository.findById(id);
		usuarioRepository.deleteById(id);
		return usuarioDel;
	}
}
