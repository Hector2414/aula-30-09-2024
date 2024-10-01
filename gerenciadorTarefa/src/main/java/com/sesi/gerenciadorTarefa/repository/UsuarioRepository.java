package com.sesi.gerenciadorTarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.gerenciadorTarefa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer >{

}
