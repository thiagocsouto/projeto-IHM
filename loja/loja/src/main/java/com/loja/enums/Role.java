package com.loja.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum Role {
	
	ADMIN("ADMIN"),
	USER("USER");
	
	private String nome;

}
