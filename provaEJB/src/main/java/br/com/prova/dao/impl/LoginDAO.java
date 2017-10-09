package br.com.prova.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.prova.vo.LoginVO;

@Stateless
public class LoginDAO extends GenericDAO<LoginVO> {

	public LoginDAO() {
		super(LoginVO.class);
	}
	
	public LoginVO getLogin(String login) {
		  Map<String, Object> parameters = new HashMap<String, Object>();
		  parameters.put("login", login);  

		  return super.findOneResult(LoginVO.FIND_BY_LOGIN, parameters);
	}
}
