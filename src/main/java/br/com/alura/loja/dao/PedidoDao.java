package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public void atualizar(Pedido pedido) {
		this.em.merge(pedido);
	}

	public void remover(Pedido pedido) {
		pedido = em.merge(pedido);
		this.em.remove(pedido);
	}
	
	public Pedido buscarPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> buscarTodos() {
		String jpql = "SELECT p FROM Pedido p";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}
	
	public List<Pedido> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Pedido p WHERE p.nome = :nome";
		return em.createQuery(jpql, Pedido.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Pedido> buscarPorNomeDaCategoria(String nome) {
		String jpql = "SELECT p FROM Pedido p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Pedido.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
		String jpql = "SELECT p.preco FROM Pedido p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

}
