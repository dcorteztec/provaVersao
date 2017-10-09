package br.com.prova.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(schema="prova",name="LOGIN")
@Entity
@NamedQuery(name="LoginVO.findLoginByLogin", query="select l from LoginVO l where l.login = :login")
public class LoginVO implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String FIND_BY_LOGIN = "LoginVO.findLoginByLogin";
	
	@Id 
	@Column(name="NOM_LOGIN") 
	private String login;
	
	@Column(name="TXT_NOME")
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
