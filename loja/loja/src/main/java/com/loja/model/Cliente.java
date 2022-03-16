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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.loja.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id") 
	private Integer id;
	
	@Column(name="nome") 
	@Size(min=3, max=50, message="O nome do cliente deverá conter no mínimo 3 letras para continuar.")
	private String nome;
	
	@Column(name="cpf")
	@Size(min=14, max=14, message="O CPF do cliente deverá seguir esse modelo: 123.123.123-12.")
	private String cpf;
	
	@Column(name="sexo")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name="idade")
	@NotNull(message="Campo obrigatório, digite a idade do cliente.")
    private Integer idade;
	 
	
//	@ManyToOne
//	private Evento evento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

//	public Evento getEvento() {
//		return evento;
//	}
//
//	public void setEvento(Evento evento) {
//		this.evento = evento;
//	}
	
	

	
	
	
	
	
	
}
