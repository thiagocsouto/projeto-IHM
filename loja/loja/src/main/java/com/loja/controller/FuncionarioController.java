package com.loja.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loja.exception.NegocioException;
import com.loja.model.Funcionario;
import com.loja.service.FuncionarioService;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/lista-funcionarios")
	public ModelAndView listaFuncionarios() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("funcionario/listaFuncionarios");
		mv.addObject("listarFuncionario", funcionarioService.listarFuncionario());
		return mv;   
	} 
	
	@GetMapping("/adicionar-funcionarios")
	public ModelAndView Adicionar(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("funcionario/adicionarFuncionarios");
		mv.addObject("funcionario", new Funcionario()); 
		return mv;  
	}
	 
	@PostMapping("/adicionar-funcionarios")
	public ModelAndView AdicionarConvidado(@Valid Funcionario funcionario, BindingResult com) {
		ModelAndView mv = new ModelAndView();
		if(com.hasErrors()) {
		mv.setViewName("funcionario/adicionarFuncionarios");
		mv.addObject(funcionario);
		return mv;
		}else {
			try {	
				funcionarioService.salvarFuncionario(funcionario);
				mv.setViewName("redirect:/lista-funcionarios");
				return mv; 
			} catch (NegocioException e) {
				com.rejectValue("cpf", "error.funcionario", e.getMessage());
				mv.setViewName("funcionario/adicionarFuncionarios");
				mv.addObject(funcionario);
				return mv; 
			}
		}
	}
	
	@GetMapping("/alterar-funcionarios/{id}") 
	public ModelAndView alterarFuncionario(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("funcionario/alterarFuncionarios");
		Optional<Funcionario> funcionario = funcionarioService.listarFuncionarioId(id);
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	@PostMapping("/alterar-funcionarios")
	public ModelAndView alterandoFuncionario(@Valid Funcionario funcionario, BindingResult com) {
		ModelAndView mv = new ModelAndView();  {
			if(com.hasErrors()) {
				mv.setViewName("funcionario/alterarFuncionarios");
				mv.addObject(funcionario);
				return mv;
			}else {
				try {	
					funcionarioService.salvarFuncionario(funcionario);
					mv.setViewName("redirect:/lista-funcionarios");
					return mv; 
				} catch (NegocioException e) {
					com.rejectValue("cpf", "error.funcionario", e.getMessage());
					mv.setViewName("funcionario/adicionarFuncionarios");
					mv.addObject(funcionario);
				    return mv;
				}
				}
			}
		}

	@GetMapping("/excluir-funcionarios/{id}")
	public String excluirFuncionario(@PathVariable("id") Integer id) {
		funcionarioService.deletarIdFuncionario(id);
		return "redirect:/lista-funcionarios";
	}

}
