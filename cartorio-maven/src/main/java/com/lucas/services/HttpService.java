package com.lucas.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
		    
		    return content;
		             
		} catch (Exception e) {
			e.printStackTrace();
			return "Tivemos um problema, verifique a conexão e as configurações do banco de dados";
		}
	}
	
	public static String alterar(Cartorio cartorio) {
		HttpClient httpclient = HttpClients.createDefault();
        
		HttpPost httppost = new HttpPost("http://localhost:9000/api/alterar-cartorio");
		         
		try { 
		    ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
		    valores.add(new BasicNameValuePair("id", String.valueOf(cartorio.getId())));
		    valores.add(new BasicNameValuePair("nome", cartorio.getNome()));
		             
		    httppost.setEntity( new UrlEncodedFormEntity( valores ) );
		    HttpResponse response = httpclient.execute( httppost );
		              
		    HttpEntity entity = response.getEntity();
		    String content = EntityUtils.toString(entity);
		    System.out.println( content );
		    
		    return content;
		             
		}catch (Exception e) {
			e.printStackTrace();
			return "Tivemos um problema, verifique a conexão e as configurações do banco de dados";
		}
	}
	
	public static String excluir(Cartorio cartorio) {
		HttpClient httpclient = HttpClients.createDefault();
        
		HttpPost httppost = new HttpPost("http://localhost:9000/api/excluir-cartorio");
		
		         
		try { 
		    ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
		    valores.add(new BasicNameValuePair("id", String.valueOf(cartorio.getId())));
		             
		    httppost.setEntity( new UrlEncodedFormEntity( valores ) );
		    HttpResponse resposta = httpclient.execute( httppost );
		              
		    HttpEntity entity = resposta.getEntity();
		    String feedback = EntityUtils.toString(entity);
		    
		    return feedback;
		             
		} catch (Exception e) {
			e.printStackTrace();
			return "Tivemos um problema, verifique a conexão e as configurações do banco de dados";
		}
	}
	
	public static List<Cartorio> listar() {
		HttpClient httpclient = HttpClients.createDefault();
        
		HttpGet httpget = new HttpGet("http://localhost:9000/api/cartorios");
		         
		HttpHost proxy = new HttpHost("localhost", 9000, "http");
		         
		RequestConfig config = RequestConfig.custom().setProxy( proxy ).build();
		         
		httpget.setConfig(config);
		
		
	    TypeToken typeToken = new TypeToken<List<Cartorio>>() {
	    };

		
	    List<Cartorio> cartorios = null;
		         
		try {
		    HttpResponse resposta = httpclient.execute(httpget);
		 
		    Gson gson = new Gson();
		    
		    HttpEntity entity = resposta.getEntity();
		    String cartorioString = EntityUtils.toString(entity);
		    
		    cartorios = gson.fromJson(cartorioString, typeToken.getType());
		    
		    return cartorios;
		 
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    httpget.releaseConnection();;
		}
		
		return cartorios;
	}
	
}
