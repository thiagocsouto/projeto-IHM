package com.loja.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.loja.enums.Cargo;
import com.loja.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity 
@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name="funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	@Size(min=3, max=50, message="O nome do funcionário deverá conter entre 3 e 50 caracteres para continuar.")
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="O nome não deve começar com uma letra minúscula, número ou caractere especial.")
	private String nome; 
	
	@Column(name="matricula")
	@Size(min=6, max=20, message="Matrícula deve ter começar com F e possuir 6 números no mínimos. Aperte no botão GERAR.")
	@Pattern(regexp = "^[F][0-9]*$", message="Matrícula inválida.")
	private String matricula;
	  
	@Column(name="cpf")
	@CPF(message="CPF inválido, insira corretamente os dados.")
	private String cpf; 
	
	@Column(name="sexo")
	@Enumerated(EnumType.STRING)
    private Sexo sexo;
	
	@Column(name="cargo")
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
	@Column(name="admissao")
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message="Data inválida.")
	private String admissao; 

}
