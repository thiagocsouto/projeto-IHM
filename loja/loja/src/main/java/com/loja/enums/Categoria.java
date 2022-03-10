package com.loja.enums;

public enum Categoria {
	
	RELÓGIO("relógio"), 
	CELULAR("celular"),
	FONE("fone"),
	COMPUTADOR("computador"),
	TV("tv");
	
	private String Categoria;

	private Categoria(String categoria) {
		Categoria = categoria;
	}

}
