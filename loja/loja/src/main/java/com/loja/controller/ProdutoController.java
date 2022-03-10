package com.loja.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.loja.model.Produto;
import com.loja.service.ProdutoService; 

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/login") 
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		mv.addObject("produto", new Produto());  
		return mv;  
	} 
	
	@GetMapping("/home") 
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("produto", new Produto());  
		return mv;   
	}
	
	@GetMapping("/cadastrar-produtos")
	public ModelAndView cadastroProduto(Produto produto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("produto/adicionarProdutos");
		mv.addObject("produto", new Produto());  
		return mv;  
	}
	
	@PostMapping("/cadastrar-produtos") 
	public ModelAndView cadastroProdutos(Produto produto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("produto/adicionarProdutos");
		mv.addObject(produto);
		mv.setViewName("redirect:/listar-produtos");
		produtoService.salvarProduto(produto);
		return mv;  
	}
	
	@GetMapping("/alterar-produtos/{id}") 
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("produto/alterarProdutos");
		Optional<Produto> produto = produtoService.listarProdutoId(id);
		mv.addObject("produto", produto);
		return mv;
	}
	
	@PostMapping("/alterar-produtos")
	public ModelAndView alterando(Produto produto) {
		ModelAndView mv = new ModelAndView(); 
		produtoService.salvarProduto(produto);
		mv.setViewName("redirect:/listar-produtos");
		return mv;
	}
	
	@GetMapping("/excluir-produtos/{id}")
	public String excluirProduto(@PathVariable("id") Integer id) {
		produtoService.deletarId(id);
		return "redirect:/listar-produtos"; 
	}  
	
	@GetMapping("/listar-produtos")
	public ModelAndView listaProdutos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("produto/listaProdutos");
		mv.addObject("listarProdutos", produtoService.listarProduto());
		return mv;  
	} 
	
//	@GetMapping("/{id}")
//	public ModelAndView detalhesEventosId(@PathVariable("id") Integer id) {
//		Optional<Evento> evento = eventoService.listarEventoId(id);
//		ModelAndView mv = new ModelAndView("detalhes");
//		mv.addObject("evento", evento);
//		return mv;  
//	}


}
