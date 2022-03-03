package com.loja.enums;

public enum Cargo {
	
	GERENTE("gerente"),
	ESTAGIÁRIO("estagiário"),
	ATENDENTE("atendente"),
	RH("rh"),
	LIMPEZA("limpeza"),
	TI("ti");
	
	private String cargo;

	private Cargo(String cargo) {
		this.cargo = cargo;
	}
	
}
