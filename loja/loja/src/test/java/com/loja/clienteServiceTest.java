package com.loja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.loja.enums.Sexo;
import com.loja.exception.NegocioException;
import com.loja.model.Cliente;
import com.loja.service.ClienteService;

@SpringBootTest
public class clienteServiceTest {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@Test
    void testeParaVerficarCadastro() {
		Cliente cliente = new Cliente("Ana Aldilha", "418.102.602-72", Sexo.FEMININO, Integer.toString(26));  
		Cliente salvarCliente = clienteService.salvarCliente(cliente);
		
		assertNotNull(salvarCliente);
	}
	
	@Test
	void testeNaoPodeIgualCpf() {
		Cliente cliente = new Cliente("Ana Aldilha", "042.588.112-11", Sexo.FEMININO, Integer.toString(26)); 
		NegocioException exception = assertThrows(NegocioException.class, ()-> clienteService.salvarCliente(cliente));
	
	   assertEquals("C.P.F já cadastrado no sistema.", exception.getMessage());
	}
	
	



}
