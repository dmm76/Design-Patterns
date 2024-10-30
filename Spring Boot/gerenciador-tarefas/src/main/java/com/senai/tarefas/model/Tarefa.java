package com.senai.tarefas.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public TarefaCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(TarefaCategoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Enumerated(EnumType.STRING)
	private StatusTarefa status;
	private LocalDate dataEntrega;
	
	private Prioridade prioridade;
	
	private boolean visivel;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private TarefaCategoria categoria;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	@Override
	public String toString() {
		return "Tarefa{" +
				"id=" + id +
				", descricao='" + descricao + '\'' +
				", status=" + status +
				", dataEntrega=" + dataEntrega +
				", prioridade=" + prioridade +
				", visivel=" + visivel +
				", categoria=" + categoria +
				", usuario=" + usuario +
				'}';
	}
}
