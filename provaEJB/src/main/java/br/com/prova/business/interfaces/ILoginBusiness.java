package br.com.prova.business.interfaces;

import javax.ejb.Local;

import br.com.prova.vo.LoginVO;

@Local
public interface ILoginBusiness {

	public void login(LoginVO loginVO);
	public abstract void save(LoginVO login);

}
