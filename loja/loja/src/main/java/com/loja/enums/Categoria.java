package com.loja.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
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

}
