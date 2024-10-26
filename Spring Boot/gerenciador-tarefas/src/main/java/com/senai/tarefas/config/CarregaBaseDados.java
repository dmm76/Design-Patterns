package com.senai.tarefas.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.senai.tarefas.model.Prioridade;
import com.senai.tarefas.model.StatusTarefa;
import com.senai.tarefas.model.Tarefa;
import com.senai.tarefas.model.TarefaCategoria;
import com.senai.tarefas.model.Usuario;
import com.senai.tarefas.repository.TarefaCategoriaRepository;
import com.senai.tarefas.repository.TarefaRepository;
import com.senai.tarefas.repository.UsuarioRepository;

@Configuration
public class CarregaBaseDados {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TarefaCategoriaRepository categoriaRepository;
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Bean
	CommandLineRunner executar() {
		return args -> {
			
			Usuario usuario = new Usuario();
			usuario.setNome("João");
			usuario.setSenha("123");
			
			Usuario usuario1 = new Usuario();
			usuario1.setNome("Douglas");
			usuario1.setSenha("456");
			
			usuarioRepository.save(usuario);
			usuarioRepository.save(usuario1);
			
			TarefaCategoria categoria = new TarefaCategoria();
			categoria.setNome("Estudos");
			categoriaRepository.save(categoria);
			
			
			TarefaCategoria categoria1 = new TarefaCategoria();
			categoria1.setNome("Pesquisa");
			categoriaRepository.save(categoria1);


			TarefaCategoria categoria2 = new TarefaCategoria();
			categoria2.setNome("Apresentação");
			categoriaRepository.save(categoria2);
			
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("Estudar Spring Boot");
			tarefa.setStatus(StatusTarefa.A_FAZER);
			tarefa.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa.setPrioridade(Prioridade.ALTA);
			tarefa.setVisivel(true);
			tarefa.setCategoria(categoria);
			tarefa.setUsuario(usuario);			
			tarefaRepository.save(tarefa);
			
		};
	}

}
