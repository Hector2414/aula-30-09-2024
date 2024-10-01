package com.sesi.gerenciadorTarefa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.gerenciadorTarefa.model.TarefaCategoria;
import com.sesi.gerenciadorTarefa.model.Usuario;
import com.sesi.gerenciadorTarefa.repository.TarefaCategoriaRepository;
import com.sesi.gerenciadorTarefa.repository.UsuarioRepository;


@Configuration
public class CarregaBaseDeDados {


	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Bean   
	CommandLineRunner executar() {
		return args ->{
			
			Usuario usuario = new Usuario();
			usuario.setNome("Hector");
			usuario.setSenha("Hector2");
			
			usuarioRepository.save(usuario);
			
			
			TarefaCategoria categoria = new TarefaCategoria();
			categoria.setNome("estudos");
			
			tarefaCategoriaRepository.save(categoria);
			
		};
	}
	
	
	
}
