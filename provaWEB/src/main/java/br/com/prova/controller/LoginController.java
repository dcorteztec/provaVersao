package br.com.prova.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.prova.business.interfaces.ILoginBusiness;
import br.com.prova.model.LoginModel;
import br.com.prova.utils.UtilsMSG;
import br.com.prova.vo.LoginVO;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LoginModel loginModel;
	
	@EJB
	private ILoginBusiness loginBusiness;

	public String login() {
		if(loginModel.getLogin()==null||loginModel.getLogin().isEmpty()) {
			UtilsMSG.Mensagem("Favor informar o login!");
			return null;
		}else {
			LoginVO login = new LoginVO();
			login.setLogin(loginModel.getLogin());
			loginBusiness.login(login);
			return "/home";
		}
	}
	
	public LoginModel getLoginModel() {
		if(loginModel==null) {
			loginModel = new LoginModel();
		}
		return loginModel;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	
}
