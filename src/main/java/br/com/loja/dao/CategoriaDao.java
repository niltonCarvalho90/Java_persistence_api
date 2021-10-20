package br.com.loja.dao;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void excluir(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
}
