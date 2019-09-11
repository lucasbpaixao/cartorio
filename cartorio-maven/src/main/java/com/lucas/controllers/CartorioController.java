package com.lucas.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.http.HttpResponse;

import com.lucas.models.Cartorio;
import com.lucas.services.HttpService;

@Named
@RequestScoped
public class CartorioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Cartorio cartorio;

	@Default
	private List<Cartorio> cartorios;

	public void listar() {
		
	}
	
	public void excluir(int id) {
		
	}
	
	public void cadastrar() {
		HttpService.cadastra(cartorio);
		listar();
		limpar();
	}
	
	public void alterar() {
		HttpService.alterar(cartorio);
		listar();
		limpar();
	}
	
	public void excluir() {
		HttpService.excluir(cartorio);
		listar();
		limpar();
	}

	public List<Cartorio> getCartorios() {
		return cartorios =  HttpService.listar();
	}

	public void setCartorios(List<Cartorio> cartorios) {
		this.cartorios =cartorios ;
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

}
