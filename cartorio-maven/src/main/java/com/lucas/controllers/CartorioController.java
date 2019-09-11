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
import org.primefaces.event.SelectEvent;

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
	
	@Default
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void listar() {
		
	}
	
	public void cadastrar() {
		
		if(cartorio.getNome().equals("") || cartorio.getNome() == null) {
			mensagem = "O campo nome não pode ser vazio";
			return;
		}
		mensagem = HttpService.cadastra(cartorio);
		listar();
		limpar();
		
	}
	
	public void alterar() {
		
		if(cartorio.getNome().equals("") || cartorio.getNome() == null || cartorio.getId() == null || cartorio.getId() == 0) {
			mensagem = "Na função alterar todos campos devem ser preenchidos";
			return;
		}
		
		mensagem = HttpService.alterar(cartorio);
		listar();
		limpar();
	}
	
	public void excluir() {
		
		if(cartorio.getId() == null) {
			mensagem = "O campo id não pode ser vazio";
			return;
		}
		
		mensagem = HttpService.excluir(cartorio);
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
