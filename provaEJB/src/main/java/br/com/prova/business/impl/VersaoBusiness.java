package br.com.prova.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.prova.business.interfaces.IVersaoBusiness;
import br.com.prova.dao.impl.ItemDAO;
import br.com.prova.dao.impl.VersaoDAO;
import br.com.prova.vo.ItemVO;
import br.com.prova.vo.VersaoVO;

@Stateless
public class VersaoBusiness implements IVersaoBusiness{

	@EJB
	private VersaoDAO dao;
	
	@EJB
	private ItemDAO itemDao;

	@Override
	public VersaoVO saveVersao(VersaoVO versaoVO) {
		 return dao.save(versaoVO);
	}

	@Override
	public void remover(Long idVersao) {
		VersaoVO versao = dao.find(idVersao);
		dao.delete(versao);
		List<ItemVO> itens = itemDao.findByItemCodVersao(idVersao);
		for (ItemVO itemVO : itens) {
			itemDao.delete(itemVO);
		}
	}

	@Override
	public VersaoVO findId(Long id) {
		return dao.find(id);
	}

	@Override
	public VersaoVO edit(VersaoVO versaoVO) {
		return dao.update(versaoVO);
	}

	

}
