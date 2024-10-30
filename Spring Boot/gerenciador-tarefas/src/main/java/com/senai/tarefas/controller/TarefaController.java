package com.senai.tarefas.controller;

import org.springframework.ui.Model;
import com.senai.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TarefaController {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping("/listarTarefas")
	public String listarTarefas(Model modelo) {
		modelo.addAttribute("tarefas", tarefaRepository.findAll());
		return "listarTarefas";
	}

}




