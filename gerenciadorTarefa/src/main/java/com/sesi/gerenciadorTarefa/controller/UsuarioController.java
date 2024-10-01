package com.sesi.gerenciadorTarefa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.sesi.gerenciadorTarefa.model.Usuario;
import com.sesi.gerenciadorTarefa.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	public UsuarioRepository usuarioRepository;

	@GetMapping("/listarUsuario")
	public String listarUsuario(Model modelo){
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		return"listarUsuario";
	}
	
	@GetMapping("/formularioUsuario")
	public String mostrarUsuario( Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		
		return"formularioUsuario";
		
	}
	
	@PostMapping("/salvarUsuario")
	public String salvarCategoria(@ModelAttribute Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/usuarios/listarUsuario";
		
	}
}
