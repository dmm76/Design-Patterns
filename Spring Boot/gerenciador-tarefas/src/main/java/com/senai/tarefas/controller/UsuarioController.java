package com.senai.tarefas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.senai.tarefas.model.Usuario;
import com.senai.tarefas.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;


	@GetMapping("/listarUsuarios")
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		return "listarUsuarios";
	}

	@GetMapping("/novo")
	public String novoUsuario(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "formulario";
	}

	@PostMapping("/salvarUsuario")
	public String salvarUsuario(@ModelAttribute Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/listarUsuarios";
	}

	@GetMapping("/removerUsuario/{id}")
	public String removerUsuario(@PathVariable("id") int id) {
		usuarioRepository.deleteById(id);
		return "redirect:/listarUsuarios";
	}

	@GetMapping("/editarUsuario/{id}")
	public String editarUsuario(@PathVariable("id") int id, Model modelo) {

		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

		if(usuarioOpt.isPresent()) {
			modelo.addAttribute("usuario", usuarioOpt.get());
			return "formulario";
		}else {
			return "redirect:/listarUsuarios";
		}

	}
}