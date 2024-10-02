package com.sesi.gerenciadorTarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.gerenciadorTarefa.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
