package com.senai.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
		
		@GetMapping("/listarUsuarios")
		public String listarUsuarios() {
			return "listarUsuarios";
		}
	
}
