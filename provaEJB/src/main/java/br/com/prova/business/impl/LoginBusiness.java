package br.com.prova.business.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.prova.business.interfaces.ILoginBusiness;
import br.com.prova.dao.impl.LoginDAO;
import br.com.prova.vo.LoginVO;

@Stateless
public class LoginBusiness implements ILoginBusiness{

	@EJB
	private LoginDAO dao;
	
	@Override
	public void login(LoginVO loginVO) {
		LoginVO login = dao.getLogin(loginVO.getLogin());
		if(login==null) {
			loginVO.setNome(loginVO.getLogin());
			save(loginVO);
		}	
	}

	@Override
	public void save(LoginVO login) {
		dao.save(login);
		
	}

}
