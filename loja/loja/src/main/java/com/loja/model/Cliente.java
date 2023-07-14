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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

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
@Table(name="cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id") 
	private Integer id;
	
	@Column(name="nome") 
	@Size(min=3, max=50, message="O nome deve conter entre 3 e 50 caracteres.")
	@Pattern(regexp = "^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="O primeiro nome não deve começar com uma letra minúscula, número ou caractere especial.")
	private String nome;
	
	@Column(name="cpf")
	@CPF(message="CPF inválido, insira corretamente os dados.")
	private String cpf;
	
	@Column(name="sexo")
	@Enumerated(EnumType.STRING) 
	private Sexo sexo;
	
	@Column(name="idade")
	@NotBlank(message="Campo obrigatório, digite a idade do cliente.")
	@Min(value=12, message="A idade do cliente minima deve ser 12 anos.")
	@Max(value=100, message="A idade do cliente não deve passar de 100 anos.")
	@Pattern(regexp = "\\d+", message="Somente números válidos no campo idade.")
    private String idade;
	
}
