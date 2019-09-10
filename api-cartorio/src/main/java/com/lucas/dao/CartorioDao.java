package com.lucas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lucas.models.Cartorio;

@Repository
public class CartorioDao {
	
	@Autowired
	private CartorioRepository repository;
	
	public void cadastrar(Cartorio cartorio) {
		System.out.println(cartorio.getNome());
		repository.save(cartorio);

	}
}
