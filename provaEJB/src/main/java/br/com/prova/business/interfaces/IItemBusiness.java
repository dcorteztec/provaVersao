package br.com.prova.business.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.prova.vo.ItemVO;
import br.com.prova.vo.VersaoVO;

@Local
public interface IItemBusiness {

	public List<ItemVO> listVersaoItem();
	public void saveIntem(ItemVO item);
	public List<ItemVO> listItemVO();
	public List<ItemVO> listVersaoItemConsultar(VersaoVO versao);
}
