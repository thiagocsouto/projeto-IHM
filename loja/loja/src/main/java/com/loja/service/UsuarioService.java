package com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.enums.Usuario;
import com.loja.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario loginUsuario(String login, String senha) throws ServiceExc{
		
		Usuario usuarioLogin = usuarioRepository.buscarLogin(login, senha);
		return usuarioLogin;
		
	}

}


