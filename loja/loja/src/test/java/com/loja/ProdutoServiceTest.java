package com.loja;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.loja.enums.Categoria;
import com.loja.model.Produto;
import com.loja.service.ProdutoService;

@SpringBootTest
public class ProdutoServiceTest {
	
		@Autowired
		private ProdutoService produtoService;
		
		@Test
	    void testeParaVerficarCadastro() {
			Produto produto = new Produto();  
			produto.setNome("Nitendo");
			produto.setPreco("2.100,00");
			produto.setCategoria(Categoria.VIDEOGAME);
			produto.setQuantidade(Integer.toString(8));
			Produto salvarProduto = produtoService.salvarProduto(produto);
			
			assertNotNull(salvarProduto);
		}

}
