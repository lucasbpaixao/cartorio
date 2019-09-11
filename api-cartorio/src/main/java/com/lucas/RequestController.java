package com.lucas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import com.lucas.dao.CartorioRepository;
import com.lucas.models.Cartorio;

@Controller
public class RequestController {
	
	@Autowired
	private CartorioRepository repository;
	
	@RequestMapping(value ="api/cadastrar-cartorio" , method=RequestMethod.POST)
	public @ResponseBody String cadastrar(@RequestParam("id") String id, @RequestParam("nome") String nome) {
		
		Cartorio cartorio = new Cartorio();
		cartorio.setId(Integer.parseInt(id));
		cartorio.setNome(nome);
		

		repository.save(cartorio);
		
		return "Cadastro efetuado com Sucesso"; 

	}
	
	@RequestMapping(value ="api/alterar-cartorio" , method=RequestMethod.POST)
	public @ResponseBody String alterar(@RequestParam("id") String id, @RequestParam("nome") String nome) {
		
		Cartorio cartorio = new Cartorio();
		cartorio.setId(Integer.parseInt(id));
		cartorio.setNome(nome);
		
		repository.save(cartorio);
		
		return "Cartorio Alterado com Sucesso"; 

	}
	
	@RequestMapping(value = "excluir-cartorio/{id}")
	public String excluirProduto(@PathVariable(value = "id") Integer id) {
		
		repository.delete(id);

		return "redirect:/cadastroProdutos";
	}
	
	
	@RequestMapping(value ="api/cartorios" , method=RequestMethod.GET)
	public @ResponseBody String listar() {
		
		Iterable<Cartorio> lista = repository.findAll();
		Gson gson = new Gson();
		
		String json = gson.toJson(lista);
		
		return json; 

	}
}
