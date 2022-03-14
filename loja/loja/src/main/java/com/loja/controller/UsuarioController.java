package com.loja.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loja.enums.Usuario;
import com.loja.model.Produto;
import com.loja.repository.UsuarioRepository;
import com.loja.service.ServiceExc;
import com.loja.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private String login;
	 
	private String senha;
	
	@GetMapping("/login") 
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		mv.addObject("usuario", new Usuario());  
		return mv;  
	} 
	 
	@GetMapping("/home") 
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("produto", new Produto());  
		return mv;   
	}  
	
	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult com, HttpSession session) throws ServiceExc{
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		if(com.hasErrors()) {
			mv.setViewName("login/login");  
		}
	
		Usuario usuarioLogin = usuarioService.loginUsuario(usuario.getLogin(),usuario.getSenha());
		if(usuarioLogin == null){
			mv.addObject("msg", "Usuario não encontrado. Tente novamente");
			mv.setViewName("login/login");  
		} else {
		   session.setAttribute("usuarioogado", usuarioLogin);
		   return index();
		}
		
		return mv;
	}
//	
//	@PostMapping("/logout")
//	public ModelAndView logout(HttpSession session) {
//		session.invalidate();
//		return login();
//	}
}
	

