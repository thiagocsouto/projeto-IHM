package com.loja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.loja.enums.Cargo;
import com.loja.enums.Sexo;
import com.loja.exception.NegocioException;
import com.loja.model.Funcionario;
import com.loja.service.FuncionarioService;

@SpringBootTest
public class FuncionarioServiceTest {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	
	@Test
    void testeParaVerficarCadastro() {
		Funcionario funcionario = new Funcionario();  
		funcionario.setNome("Deivid Carlos");
		funcionario.setMatricula("F003456");
		funcionario.setCpf("418.102.602-72");
		funcionario.setSexo(Sexo.MASCULINO);
		funcionario.setCargo(Cargo.ENGENHEIRO);
		funcionario.setAdmissao("01/03/2022");
		Funcionario salvarFuncionario = funcionarioService.salvarFuncionario(funcionario);
		
		assertNotNull(salvarFuncionario);
	}
	
	@Test
	void testeNaoPodeIgualCpf() {
		Funcionario funcionario = new Funcionario();   
		funcionario.setNome("Deivid Carlos");
		funcionario.setMatricula("F03568");
		funcionario.setCpf("042.588.112-11");
		funcionario.setSexo(Sexo.MASCULINO);
		funcionario.setCargo(Cargo.ENGENHEIRO);
		funcionario.setAdmissao("01/03/2022");

		NegocioException exception = assertThrows(NegocioException.class, ()-> funcionarioService.salvarFuncionario(funcionario));
	
	   assertEquals("C.P.F já cadastrado no sistema.", exception.getMessage());
	}
	

}
