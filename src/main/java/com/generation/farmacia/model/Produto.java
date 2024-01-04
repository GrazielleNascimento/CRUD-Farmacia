package com.generation.farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // define que sera uma tabela
@Table(name = "tb_produto") // nomeia a tabela
public class Produto {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
	private Long id;
	
	@Column(length= 1000)//sobrescrevendo a quantidade padrao de caracteres maximo
	@NotBlank(message = "O atributo texto é Obrigatório!")
	@Size(min = 3, max = 1000, message = "O atributo nome deve conter no mínimo 3 e no máximo 1000 caracteres")
	private String nome;
    
	@NotNull(message = "O atributo preço é obrigatório.")
	@DecimalMin(value = "0.01", inclusive = true, message = "O preço mínimo deve ser 0.01.")
	@DecimalMax(value = "999999.99", inclusive = true, message = "O preço máximo permitido é 999999.99.")
	private BigDecimal preco;
	
	@Column
	@NotNull(message = "A quantidade em estoque é obrigatória.")
	@Min(value = 0, message = "A quantidade em estoque não pode ser negativa.")
	@Max(value = Integer.MAX_VALUE, message = "A quantidade em estoque excede o valor máximo permitido.")
	private int quantidadeEmEstoque;
	
	@NotBlank(message = "O atributo fabricante é obrigatório.")
	@Size(min = 3, max = 255, message = "O atributo fabricante deve conter entre 3 e 255 caracteres.")
	private String fabricante;
	
	@ManyToOne 
	@JsonIgnoreProperties("produtos") 
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
