package com.loja.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.webjars.NotFoundException;

import com.loja.model.Produto;
import com.loja.model.Role;
import com.loja.model.Usuario;
import com.loja.repository.UsuarioRepository;




@Controller
public class UsuarioController {
	
	@Autowired
	private UserDetailsService usuarioService;
	
	
	@GetMapping("/login") 
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		mv.addObject("usuario", new Usuario());  
		
		
//	        if ( Utils.hasRole("ROLE_ADMIN") ) {
//	            retorno = "redirect:/gerencia/";
//	        }
		
		return mv;  
		
		 
	} 
//verficar a role que entra com o usuario
//	@AuthenticationPrincipal Usuario usuario
//	System.out.println(usuario.getAuthorities());
	 
	@GetMapping("/home") 
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("home/index");
		mv.addObject("produto", new Produto());  
		return mv;   
	}  
	
	
	@GetMapping("/admin/home") 
	public ModelAndView indexAdmin() {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("home/index");
		mv.addObject("produto", new Produto());  
		return mv;   
	}
	 
	
//	
//	@PostMapping("/logout")
//	public ModelAndView logout(HttpSession session) {
//		session.invalidate();
//		return login();
//	}
}
	

