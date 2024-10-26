package com.senai.tarefas.controller;

import com.senai.tarefas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.senai.tarefas.model.TarefaCategoria;
import com.senai.tarefas.repository.TarefaCategoriaRepository;

import java.util.Optional;


@Controller
public class TarefaCategoriaController {

	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;

	@GetMapping("/listarCategoria")
	public String listarTarefasCategoria(Model modelo) {
		modelo.addAttribute("tarefasCategoria", tarefaCategoriaRepository.findAll());
		return "listarCategoria";
	}

	@GetMapping("/removerCategoria/{id}")
	public String removerCategoria(@PathVariable("id") int id) {
		tarefaCategoriaRepository.deleteById(id);
		return "redirect:/listarCategoria";
	}

	@GetMapping("/editarCategoria/{id}")
	public String editarCategoria(@PathVariable("id") int id, Model modelo) {

		Optional<TarefaCategoria> tarefaCategoriaOpt = tarefaCategoriaRepository.findById(id);

		if(tarefaCategoriaOpt.isPresent()) {
			modelo.addAttribute("categoria", tarefaCategoriaOpt.get());
			return "formulario";
		}else {
			return "redirect:/listarCategoria";
		}

	}

	@PostMapping("/salvarCategoria")
	public String salvarCategoria(@ModelAttribute TarefaCategoria tarefaCategoria) {
		tarefaCategoriaRepository.save(tarefaCategoria);
		return "redirect:/listarCategoria";
	}

	@GetMapping("/novaCategoria")
	public String novaCategoria(Model modelo) {
		modelo.addAttribute("categoria", new TarefaCategoria());
		return "formularioCategoria";
	}

}
