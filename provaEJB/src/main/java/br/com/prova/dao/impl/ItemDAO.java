package br.com.prova.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.prova.vo.ItemVO;
import br.com.prova.vo.VersaoVO;

@Stateless
public class ItemDAO extends GenericDAO<ItemVO> {

	public ItemDAO() {
		super(ItemVO.class);
	}

	@SuppressWarnings("unchecked")
	public List<ItemVO> findByItemVersao() {
		List<ItemVO> retorno = new ArrayList<ItemVO>();
		StringBuffer q = new StringBuffer();
		q.append("SELECT v.NRO_VERSAO,vt.COD_ITEM,item.DSC_TITULO FROM prova.versao_item vt\r\n"
				+ "INNER JOIN prova.versao v\r\n" + "ON vt.COD_VERSAO = v.COD_VERSAO\r\n"
				+ "INNER JOIN prova.item item\r\n" + "ON vt.COD_ITEM = item.COD_ITEM\r\n");
		Query query = em.createNativeQuery(q.toString());
		List<Object[]> ret = (List<Object[]>) query.getResultList();
		for (Object[] object : ret) {
			ItemVO item = new ItemVO();
			item.getVersao().setNumero(object[0].toString());
			item.setTitulo(object[1].toString());
			item.setDescricao(object[2].toString());
			retorno.add(item);
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<ItemVO> findByItemCodVersao(Long codigo) {
		List<ItemVO> retorno = new ArrayList<ItemVO>();
		StringBuffer q = new StringBuffer();
		q.append("SELECT v.NRO_VERSAO,vt.COD_ITEM,item.DSC_TITULO FROM prova.versao_item vt\r\n"
				+ "INNER JOIN prova.versao v\r\n" + "ON vt.COD_VERSAO = v.COD_VERSAO\r\n"
				+ "INNER JOIN prova.item item\r\n" + "ON vt.COD_ITEM = item.COD_ITEM\r\n"
				+ "WHERE vt.COD_VERSAO = :codigo");
		Query query = em.createNativeQuery(q.toString());
		query.setParameter("codigo", codigo);
		List<Object[]> ret = (List<Object[]>) query.getResultList();
		for (Object[] object : ret) {
			ItemVO item = new ItemVO();
			item.getVersao().setNumero(object[0].toString());
			item.setTitulo(object[1].toString());
			item.setDescricao(object[2].toString());
			retorno.add(item);
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<ItemVO> listVersaoItemConsultar(VersaoVO versao) {
		List<ItemVO> retorno = new ArrayList<ItemVO>();
		StringBuffer q = new StringBuffer();
		q.append("SELECT v.NRO_VERSAO,vt.COD_ITEM,item.DSC_TITULO FROM prova.versao_item vt ");
		q.append("INNER JOIN prova.versao v ");
		q.append("ON vt.COD_VERSAO = v.COD_VERSAO ");
		q.append("INNER JOIN prova.item item ");
		q.append(" ON vt.COD_ITEM = item.COD_ITEM WHERE");
		if (versao.getNumero() != null) {
			q.append("   v.NRO_VERSAO = :numero  ");
		}
		if (versao.getCodigo() != null) {
			q.append("   AND v.COD_VERSAO = :codigo ");
		}
		if (versao.getData() != null) {
			q.append("   AND v.DAT_VERSAO =  :data ");
		}
		Query query = em.createNativeQuery(q.toString());
		if (versao.getCodigo() != null) {
			query.setParameter("codigo", versao.getCodigo());
		}
		if (versao.getData() != null) {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			String dataFormatada = formato.format(versao.getData());
			query.setParameter("data", dataFormatada);
		}
		if (versao.getNumero() != null) {
			query.setParameter("numero", versao.getNumero());
		}
		try {
			List<Object[]> ret = (List<Object[]>) query.getResultList();
			for (Object[] object : ret) {
				ItemVO item = new ItemVO();
				item.getVersao().setNumero(object[0].toString());
				item.setTitulo(object[1].toString());
				item.setDescricao(object[2].toString());
				retorno.add(item);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return retorno;
	}

}
