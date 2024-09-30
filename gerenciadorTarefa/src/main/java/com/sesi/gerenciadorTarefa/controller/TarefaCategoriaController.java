package com.sesi.gerenciadorTarefa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sesi.gerenciadorTarefa.model.TarefaCategoria;
import com.sesi.gerenciadorTarefa.repository.TarefaCategoriaRepository;

@Controller
public class TarefaCategoriaController {

	@Autowired
	TarefaCategoriaRepository tarefaCategoriaRepository;
	
	
	@GetMapping("/listarCategoria")
	public String listarCategoria(Model modelo){
		modelo.addAttribute("categorias", tarefaCategoriaRepository.findAll());
		return"listarTarefaCategoria";
	}
	
	@GetMapping("/editarCategoria/{id}")
	public String editarCategoria(@PathVariable("id") int id, Model modelo) {
		Optional<TarefaCategoria> categoriaOpt = tarefaCategoriaRepository.findById(id);
		
		
		if (categoriaOpt.isPresent()) {
			modelo.addAttribute("categroia", categoriaOpt.get());
			return"formularioTarefaCategoria";
		} else {
			return "redirect:/listarTarefaCategoria";
		}
	}
	
	@GetMapping("/formularioCategoria")
	public String mostrarFormulario() {
		
		return"formularioTarefaCategoria";
	}
}
