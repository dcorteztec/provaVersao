package br.com.prova.dao.impl;

import javax.ejb.Stateless;

import br.com.prova.vo.VersaoVO;

@Stateless
public class VersaoDAO extends GenericDAO<VersaoVO>{

	public VersaoDAO() {
		super(VersaoVO.class);
	}

}
