package com.lucas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lucas.models.Cartorio;

public class CartorioDao {
	@PersistenceContext
	private static EntityManager em;
	
	public static void cadastrar(Cartorio cartorio) {
		em.persist(cartorio);
	}
}
