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

import com.loja.enums.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name ="nome")
	private String nome;  
	
	@Column(name ="preço")
	private String preco;
	
	@Column(name ="categoria")
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Column(name ="quantidade") 
	private Integer quantidade;
	
//	@OneToMany 
//	private List<Convidado> convidado;
	
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
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
//	public List<Convidado> getConvidado() {
//		return convidado;
//	}
//	public void setConvidado(List<Convidado> convidado) {
//		this.convidado = convidado;
//	}
	
	
	
	
	
	
	
	
}
