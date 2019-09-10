package com.lucas.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.primefaces.json.JSONObject;

import com.lucas.models.Cartorio;

public class HttpService {

	public static String cadastra(Cartorio cartorio) {
		HttpClient httpclient = HttpClients.createDefault();
        
		HttpPost httppost = new HttpPost("http://localhost:9000/api/cadastrar-cartorio");
		         
		try { 
		    ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
		    valores.add(new BasicNameValuePair("id", String.valueOf(cartorio.getId())));
		    valores.add(new BasicNameValuePair("nome", cartorio.getNome()));
		             
		    httppost.setEntity( new UrlEncodedFormEntity( valores ) );
		    HttpResponse response = httpclient.execute( httppost );
		              
		    HttpEntity entity = response.getEntity();
		    String content = EntityUtils.toString(entity);
		    System.out.println( content );
		             
		} catch (ClientProtocolException e) {
		    //e.printStackTrace();
		} catch (IOException e) {
		    //e.printStackTrace();
		} finally {
		   // httppost.releaseConnection();;
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
