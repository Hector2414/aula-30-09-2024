package com.sesi.gerenciadorTarefa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.gerenciadorTarefa.model.TarefaCategoria;
import com.sesi.gerenciadorTarefa.repository.TarefaCategoriaRepository;


@Configuration
public class CarregaBaseDeDados {


	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	
	@Bean   
	CommandLineRunner executar() {
		return args ->{
			TarefaCategoria categoria = new TarefaCategoria();
			categoria.setNome("estudos");
			
			tarefaCategoriaRepository.save(categoria);
			
		};
	}
	
	
	
}
