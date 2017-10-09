package br.com.prova.business.interfaces;

import javax.ejb.Local;

import br.com.prova.vo.AudVersaoVO;

@Local
public interface IAudVersaoBusiness {

	public void saveAud(AudVersaoVO audVersaoVO);
}
