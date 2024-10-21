package com.senai.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.tarefas.model.TarefaCategoria;

public interface TarefaCategoriaRepository extends JpaRepository<TarefaCategoria, Integer> {

}
