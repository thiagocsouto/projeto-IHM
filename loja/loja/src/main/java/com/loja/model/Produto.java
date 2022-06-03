package com.loja.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.loja.enums.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id") 
	private Integer id;
	
	@Column(name ="nome")
	@Size(min=3, max=50, message="O nome do produto deverá conter entre 3 e 50 caracteres para continuar.")
	private String nome;  
	
	@Column(name ="preço")
	@Size(min=1, max=20, message="O preço do produto é obrigatório.")
	@Pattern(regexp = "^\\d{1,3}(\\.\\d{3})*,\\d{2}$", message="Digite um preço válido.")
	private String preco;
	
	@Column(name ="categoria") 
	@Enumerated(EnumType.STRING)
	private Categoria categoria; 
	
	@Column(name ="quantidade") 
	@NotNull(message="Campo obrigatório, digite a quantidade do produto.")
	@Min(value=1, message="Não pode ter abaixo de zero a quantidade de produtos.")
	@Max(value=250, message="Quantidade máxima de 250 produtos foi atiginda.")
	@Pattern(regexp = "\\d+", message="Somente números válidos no campo idade.")
	private String quantidade;
	
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
}
