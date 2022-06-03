package com.loja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.exception.NegocioException;
import com.loja.model.Cliente;
import com.loja.model.Funcionario;
import com.loja.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario salvarFuncionario(Funcionario funcionario){
		
        Funcionario cpfExiste = funcionarioRepository.findByCpf(funcionario.getCpf());
		
		if (cpfExiste!= null) {
			throw new NegocioException("C.P.F já cadastrado no sistema");
		}
		
		
		return funcionarioRepository.save(funcionario);
	}
	
	public List<Funcionario> listarFuncionario() {
		return funcionarioRepository.findAll();
	}
	
	public Optional<Funcionario> listarFuncionarioId(Integer id) {
		return funcionarioRepository.findById(id);
	}

	public void deletarIdFuncionario(Integer id) {
	    funcionarioRepository.deleteById(id); 
	}

}
