package com.loja.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum Sexo {
	
	MASCULINO("masculino"),
	FEMININO("feminino"),
	OUTRO("outro");
	
	private String Sexo;
	
} 
