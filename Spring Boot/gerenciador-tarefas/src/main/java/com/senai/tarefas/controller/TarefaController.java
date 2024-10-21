package com.senai.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TarefaController {
	
	@GetMapping("/listarTarefas")
	public String listarTarefas() {
		return "listarTarefas";
	}

}




