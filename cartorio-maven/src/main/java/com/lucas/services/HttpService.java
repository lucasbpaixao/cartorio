package com.lucas.services;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import com.lucas.models.Cartorio;

public class HttpService {

	public static String cadastra(Cartorio cartorio) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httpget = new HttpPost("http://localhost:3000/api/cadastrar-cartorio");
		try {
		    HttpResponse resposta = httpclient.execute(httpget);
		 
		    
		 
		} catch (ClientProtocolException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    httpget.releaseConnection();;
		}
		
		return null;
	}
	
	public static String alterar(Cartorio cartorio) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httpget = new HttpPost("http://localhost:3000/api/alterar-cartorio");
		try {
		    HttpResponse resposta = httpclient.execute(httpget);
		 
		    
		 
		} catch (ClientProtocolException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    httpget.releaseConnection();;
		}
		
		return null;
	}
	
	public static String excluir(Integer id) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httpget = new HttpPost("http://localhost:3000/api/excluir-cartorio"+ id);
		try {
		    HttpResponse resposta = httpclient.execute(httpget);
		 
		    
		 
		} catch (ClientProtocolException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    httpget.releaseConnection();;
		}
		
		return null;
	}
	
	public static List<Cartorio> listar() {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httpget = new HttpPost("http://localhost:3000/api/cartorios");
		try {
		    HttpResponse resposta = httpclient.execute(httpget);
		 
		    
		 
		} catch (ClientProtocolException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    httpget.releaseConnection();;
		}
		
		return null;
	}
	
	public static Cartorio visualizarCartorio(Integer id) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httpget = new HttpPost("http://localhost:3000/api/visualizar-cartorio" + id);
		try {
		    HttpResponse resposta = httpclient.execute(httpget);
		 
		    
		 
		} catch (ClientProtocolException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    httpget.releaseConnection();;
		}
		
		return null;
	}
}
