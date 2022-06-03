package com.loja.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loja.model.Produto;
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
		return mv;  
	} 
	 
	@GetMapping("/home") 
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("home/index");
		mv.addObject("produto", new Produto());  
		return mv;   
	}  
	
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
	

