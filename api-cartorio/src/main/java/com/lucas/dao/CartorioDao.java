package com.lucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lucas.models.Cartorio;


public class CartorioDao {
	@PersistenceContext
	private EntityManager em;
	
	public void cadastrar(Cartorio cartorio) {
		em.getTransaction().begin();
		em.persist(cartorio);
		em.getTransaction().commit();
		em.close();
	}
}
