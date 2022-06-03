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
import com.loja.model.Cliente;
import com.loja.service.ClienteService;

@Controller 
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService; 
	
	@GetMapping("/adicionar-clientes")
	public ModelAndView Adicionar(Cliente cliente) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cliente/adicionarClientes");
		mv.addObject("cliente", new Cliente()); 
		return mv;  
	}  
	 
	@PostMapping("/adicionar-clientes")
	public ModelAndView AdicionarCliente(@Valid Cliente cliente, BindingResult com){
		ModelAndView mv = new ModelAndView();
		if(com.hasErrors()) {
			mv.setViewName("cliente/adicionarClientes");
			mv.addObject(cliente);
			return mv;
		} else {	
			try {	
				clienteService.salvarCliente(cliente);
				mv.setViewName("redirect:/lista-clientes");
				return mv; 
			} catch (NegocioException e) {
				com.rejectValue("cpf", "error.cliente", e.getMessage());
				mv.setViewName("cliente/adicionarClientes");
				mv.addObject(cliente);
				return mv; 
			}
		}
		
	}
	
	@GetMapping("/lista-clientes")
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cliente/listaClientes");
		mv.addObject("listarClientes", clienteService.listarCliente());
		return mv;   
	}  
	
	@GetMapping("/alterar-clientes/{id}") 
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cliente/alterarClientes");
		Optional<Cliente> cliente = clienteService.listarClienteId(id);
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/alterar-clientes")
	public ModelAndView alterando(@Valid Cliente cliente, BindingResult com) {
		ModelAndView mv = new ModelAndView(); 
		if(com.hasErrors()) {
			mv.setViewName("cliente/alterarClientes");
			mv.addObject(cliente);
			return mv;
		}else {
			try {	
				clienteService.salvarCliente(cliente);
				mv.setViewName("redirect:/lista-clientes");
				return mv; 
			} catch (NegocioException e) {
				com.rejectValue("cpf", "error.cliente", e.getMessage());
				mv.setViewName("cliente/adicionarClientes");
				mv.addObject(cliente);
				return mv; 
			}
		}
	} 
	
	@GetMapping("/excluir-clientes/{id}")
	public String excluirConvidado(@PathVariable("id") Integer id) {
		clienteService.deletarIdCliente(id);
		return "redirect:/lista-clientes";
	}

}
