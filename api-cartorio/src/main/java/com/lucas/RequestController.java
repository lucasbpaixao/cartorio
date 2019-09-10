package com.lucas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucas.dao.CartorioDao;
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
		
//		CartorioDao dao = new CartorioDao();
		repository.save(cartorio);
		
		return "Cadastro efetuado com Sucesso"; 

	}
}
