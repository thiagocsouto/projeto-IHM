package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	Funcionario findByCpf(String cpf);

	

}
