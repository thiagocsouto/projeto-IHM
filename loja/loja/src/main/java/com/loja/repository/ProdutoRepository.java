package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.loja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}  
