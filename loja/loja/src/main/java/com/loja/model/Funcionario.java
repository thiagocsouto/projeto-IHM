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

import com.loja.enums.Cargo;
import com.loja.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="funcionario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome") 
	private String nome;
	
	@Column(name="matricula")
	private String matricula;
	 
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="sexo")
	@Enumerated(EnumType.STRING)
    private Sexo sexo;
	
	@Column(name="cargo")
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
	@Column(name="admissao")
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
