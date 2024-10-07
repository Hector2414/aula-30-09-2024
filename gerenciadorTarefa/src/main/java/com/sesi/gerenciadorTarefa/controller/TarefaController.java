package com.sesi.gerenciadorTarefa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sesi.gerenciadorTarefa.model.Tarefa;
import com.sesi.gerenciadorTarefa.repository.TarefaCategoriaRepository;
import com.sesi.gerenciadorTarefa.repository.TarefaRepository;
import com.sesi.gerenciadorTarefa.repository.UsuarioRepository;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TarefaCategoriaRepository categoriaRepository;

	@GetMapping("/listarTarefas")
	public String listarTarefas(Model modelo) {
		modelo.addAttribute("tarefas", tarefaRepository.findAll());
		return"listarTarefas";
	}
	
	@GetMapping("/novo")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("tarefa", new Tarefa());
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		modelo.addAttribute("categorias", categoriaRepository.findAll());
		return"formularioTarefa";
	}
	
	
	@PostMapping("/salvarTarefa")
	public String salvarTarefa(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
		return"redirect:/tarefas/listarTarefas";
		
	} 
	
}
