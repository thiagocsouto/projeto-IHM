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
import org.springframework.format.annotation.DateTimeFormat;

import com.loja.enums.Cargo;
import com.loja.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	@Size(min=3, max=50, message="O nome do funcionário deverá conter entre 3 e 50 caracteres para continuar.")
	@Pattern(regexp = "^[A-Z][a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÒÖÚÇÑ ]*$", message="O primeiro nome não deve começar com uma letra minúscula, número ou caractere especial.")
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
	
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getCpf() {
		return cpf;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public String getAdmissao() {
		return admissao;
	}
	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}
	
	
	
	
	
	
	
	
	
}
