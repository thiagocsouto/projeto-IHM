package com.loja.enums;

public enum Cargo {
	
	GERENTE("gerente"),
	ENGENHEIRO("engenheiro"),
	ESTAGIÁRIO("estagiário"),
	ATENDENTE("atendente"),
	SEGURANÇA("segurança"),
	RH("rh"),
	LIMPEZA("limpeza"),
	TI("ti");
	
	private String cargo;

	private Cargo(String cargo) {
		this.cargo = cargo;
	}
	
}
