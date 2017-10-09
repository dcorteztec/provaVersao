package br.com.prova.business.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.prova.business.interfaces.IAudVersaoBusiness;
import br.com.prova.dao.impl.AudVersaoDAO;
import br.com.prova.vo.AudVersaoVO;

@Stateless
public class AudVersaoBusiness implements IAudVersaoBusiness{

	@EJB
	private AudVersaoDAO dao;
	
	@Override
	public void saveAud(AudVersaoVO audVersaoVO) {
		dao.save(audVersaoVO);
		
	}

}
