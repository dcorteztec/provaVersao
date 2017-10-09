package br.com.prova.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.prova.vo.AudVersaoVO;

@Stateless
public class AudVersaoDAO extends GenericDAO<AudVersaoVO>{

	public AudVersaoDAO() {
		super(AudVersaoVO.class);
	}
	
	public AudVersaoVO getByAudByCodVersao(String codVersao) {
		AudVersaoVO retorno = new AudVersaoVO();
		StringBuffer q = new StringBuffer();
		q.append("SELECT a FROM AudVersaoVO a where a.versao.codigo = :codVersao");
		Query query = em.createQuery(q.toString());
		query.setParameter("codVersao", codVersao);
		retorno = (AudVersaoVO) query.getSingleResult();
		return retorno;
	}
}
