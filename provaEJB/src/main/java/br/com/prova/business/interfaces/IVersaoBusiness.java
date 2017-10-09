package br.com.prova.business.interfaces;

import javax.ejb.Local;

import br.com.prova.vo.VersaoVO;

@Local
public interface IVersaoBusiness {

	public VersaoVO saveVersao(VersaoVO versaoVO);
	public void remover(Long idVersao);
	public VersaoVO findId(Long id);
	public VersaoVO edit(VersaoVO versaoVO);
}
