package com.senai.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
