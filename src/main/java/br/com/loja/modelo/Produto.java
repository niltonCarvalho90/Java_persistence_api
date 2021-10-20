package br.com.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")//Se quizer alterar nome da tabela no Banco de dados
public class Produto { //Se não alterado o nome da tabela será o nome da classe
		
		@Id//Indicar para o JPA que esse atributo é a chave primária
		@GeneratedValue(strategy = GenerationType.IDENTITY)//Indicar quem vai gerar o próximo Id
		private long id;
		private String nome;
		private String descricao;
		private BigDecimal preco;
		private LocalDate dataCadastro = LocalDate.now();
		
		@ManyToOne //Cardinalidade de produtos para categoria(MUITOS para UM)
		private Categoria categoria;
		
		public Produto() {
			
		}
		
		public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		
			this.nome = nome;
			this.descricao = descricao;
			this.preco = preco;
			this.categoria = categoria;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public BigDecimal getPreco() {
			return preco;
		}
		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}
		public LocalDate getDataCadastro() {
			return dataCadastro;
		}
		public void setDataCadastro(LocalDate dataCadastro) {
			this.dataCadastro = dataCadastro;
		}
		public Categoria getCategoria() {
			return categoria;
		}
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
	
		
	}
