package br.com.prova.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.prova.business.interfaces.IItemBusiness;
import br.com.prova.dao.impl.ItemDAO;
import br.com.prova.vo.ItemVO;
import br.com.prova.vo.VersaoVO;

@Stateless
public class ItemBusiness implements IItemBusiness{

	@EJB 
	private ItemDAO dao;
	
	
	@Override
	public List<ItemVO> listItemVO() {
		return dao.findAll();
	}

	@Override
	public List<ItemVO> listVersaoItem() {
		return dao.findByItemVersao();
	}


	@Override
	public void saveIntem(ItemVO item) {
		dao.save(item);
		
	}

	@Override
	public List<ItemVO> listVersaoItemConsultar(VersaoVO versao) {
		return dao.listVersaoItemConsultar(versao);
	}

}
