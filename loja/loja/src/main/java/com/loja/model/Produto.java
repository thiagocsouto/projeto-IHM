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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(min=3, max=50, message="O nome do produto deverá conter no mínimo 3 letras para continuar")
	private String nome;  
	
	@Column(name ="preço")
	@Size(min=1, max=20, message="O preço do produto é obrigatório")
	private String preco;
	
	@Column(name ="categoria") 
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Column(name ="quantidade") 
	@NotNull(message="Campo obrigatório, digite a quantidade do produto.")
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
