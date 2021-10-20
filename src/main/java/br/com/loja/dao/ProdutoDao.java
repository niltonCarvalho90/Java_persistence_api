package br.com.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);//find  faz a busca de uma entidade por Id
	}
	
	public List<Produto> buscarTodos(){
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();//getResultList dispara no BD, CreteQuery monta
	}
	
	public List<Produto> buscarPorNome(String nome){
		String jpql = "SELECT p FROM Produto p Where p.nome = : buscarNome"; //nome é o NOME do atributo, : serve p/ passar parametro para a Query
		return em.createQuery(jpql, Produto.class)
		.setParameter("buscarNome", nome) // Nome do parametro e valor, que no caso vai ser recebido
		.getResultList();//getResultList() dispara no BD, CreteQuery monta(Carrega uma lista)
	}
	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome){
		String jpql = "SELECT p.preco FROM Produto p Where p.nome = :buscarPrecoNome"; //nome é o NOME do atributo, : serve p/ passar parametro para a Query
		return em.createQuery(jpql, BigDecimal.class)//Retorno igual o tipo da classe BigDecimal
		.setParameter("buscarPrecoNome", nome) // Nome do parametro e valor, que no caso vai ser recebido
		.getSingleResult();//getSingleResult() dispara no BD, CreteQuery monta(Carrega uma lista)
	}
}
