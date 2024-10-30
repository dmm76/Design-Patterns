package com.senai.tarefas.controller;

import com.senai.tarefas.model.Tarefa;
import com.senai.tarefas.model.Usuario;
import org.springframework.ui.Model;
import com.senai.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TarefaController {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping("/listarTarefas")
	public String listarTarefas(Model modelo) {
		modelo.addAttribute("tarefas", tarefaRepository.findAll());
		return "listarTarefas";
	}
	@GetMapping("/novaTarefa")
	public String novaTarefa(Model modelo) {
		modelo.addAttribute("tarefa", new Tarefa());
		return "formularioTarefa";
	}

	@PostMapping("/salvarTarefa")
	public String salvarTarefa(@ModelAttribute Tarefa tarefa) {
		tarefaRepository.save(tarefa);
		return "redirect:/listarTarefas";
	}

	@GetMapping("/removerTarefa/{id}")
	public String removerTarefa(@PathVariable("id") int id) {
		tarefaRepository.deleteById(id);
		return "redirect:/listarTarefas";
	}

	@GetMapping("/editarTarefa/{id}")
	public String editarTarefa(@PathVariable("id") int id, Model modelo) {

		Optional<Tarefa> tarefaOpt = tarefaRepository.findById(id);

		if (tarefaOpt.isPresent()) {
			modelo.addAttribute("tarefa", tarefaOpt.get());
			return "formularioTarefa";
		} else {
			return "redirect:/listarTarefas";
		}
	}
}




