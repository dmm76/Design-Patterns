package com.senai.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.tarefas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
 
}
