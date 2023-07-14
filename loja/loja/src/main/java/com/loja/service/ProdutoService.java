package com.loja.service;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.model.Produto;
import com.loja.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvarProduto(Produto produto){
		return produtoRepository.save(produto);
	} 

	public List<Produto> listarProduto() {
		return produtoRepository.findAll();
		
	}

	public Optional<Produto> listarProdutoId(Integer id) {
		return produtoRepository.findById(id);
	}

	public void deletarId(Integer id) { 
		 produtoRepository.deleteById(id);
	}

}  
