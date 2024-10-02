package com.sesi.gerenciadorTarefa.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.gerenciadorTarefa.model.Prioridade;
import com.sesi.gerenciadorTarefa.model.StatusTarefa;
import com.sesi.gerenciadorTarefa.model.Tarefa;
import com.sesi.gerenciadorTarefa.model.TarefaCategoria;
import com.sesi.gerenciadorTarefa.model.Usuario;
import com.sesi.gerenciadorTarefa.repository.TarefaCategoriaRepository;
import com.sesi.gerenciadorTarefa.repository.TarefaRepository;
import com.sesi.gerenciadorTarefa.repository.UsuarioRepository;


@Configuration
public class CarregaBaseDeDados {


	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
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
			
			
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("Estudar mais o Spring Boot");
		    tarefa.setStatus(StatusTarefa.A_FAZER);
		    tarefa.setDataEntrega(LocalDate.now().plusDays(1));
		    tarefa.setPrioridade(Prioridade.MEDIA);
		    tarefa.setVisivel(true);
		    tarefa.setCategoria(categoria);
		    tarefa.setUsuario(usuario);
		    
		    
			
		    tarefaRepository.save(tarefa);
		    
		};
	}
	
	
	
}
