package br.com.prova.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class HomeController {

	public String manter() {
		return "/manter";
	}
	public String incluir() {
		return "/incluir";
	}
}
