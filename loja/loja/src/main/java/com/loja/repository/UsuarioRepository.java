package com.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loja.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
//	@Query("select b from Usuario b where b.login = :login and b.senha = :senha")
//	public Usuario buscarLogin(String login, String senha); 
	
	public Usuario findByUsername(String username);  

}
