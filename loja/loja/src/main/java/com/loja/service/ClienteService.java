package com.loja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.model.Cliente;
import com.loja.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvarCliente(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> listarClienteId(Integer id) {
		return clienteRepository.findById(id);
	}

	public void deletarIdCliente(Integer id) {
	    clienteRepository.deleteById(id);
	}

	
}
