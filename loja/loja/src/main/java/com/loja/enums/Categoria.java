package com.loja.enums;

public enum Categoria {
	
	RELÓGIO("relógio"), 
	SMARTPHONE("smartphone"), 
	SMARTWATCH("smartwatch"),
	TABLET("tablet"),
	VIDEOGAME("videogame"),
	COMPUTADOR("computador"),
	NOTEBOOK("notebook"),
	MOUSE("mouse"),
	TECLADO("teclado"),
	TV("tv");
	
	
	
	private String Categoria;

	private Categoria(String categoria) {
		Categoria = categoria;
	}

}
