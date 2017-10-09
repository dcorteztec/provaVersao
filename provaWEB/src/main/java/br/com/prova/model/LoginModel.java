package br.com.prova.model;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

@SessionScoped
public class LoginModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String login;
	private String nome;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
