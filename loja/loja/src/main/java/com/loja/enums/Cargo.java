package com.loja.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
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

}
