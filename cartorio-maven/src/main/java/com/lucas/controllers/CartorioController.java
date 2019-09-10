package com.lucas.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucas.models.Cartorio;
import com.lucas.services.HttpService;

@Named
@SessionScoped
public class CartorioController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cartorio cartorio;
	
	@Default
	private String mensagem;
	
	public void cadastrar() {
		mensagem = HttpService.cadastra(cartorio);
		limpar();
	}
	

	private void limpar() {
		cartorio = new Cartorio();
	} 
	
	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


}
