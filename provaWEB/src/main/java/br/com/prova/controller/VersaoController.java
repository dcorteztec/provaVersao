package br.com.prova.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.prova.business.interfaces.IAudVersaoBusiness;
import br.com.prova.business.interfaces.IItemBusiness;
import br.com.prova.business.interfaces.IVersaoBusiness;
import br.com.prova.model.VersaoModel;
import br.com.prova.vo.AudVersaoVO;
import br.com.prova.vo.ItemVO;
import br.com.prova.vo.VersaoVO;

@ManagedBean
@SessionScoped
public class VersaoController implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private IVersaoBusiness versaoBusiness;

	@EJB
	private IItemBusiness itemBusiness;
	
	@EJB
	private IAudVersaoBusiness audVersaoBusiness;
	
	private VersaoModel versaoModel;

	public String saveVersao() {
		versaoBusiness.saveVersao(preparaVersao(versaoModel));
		
		return "/manter";
	}
	
	public VersaoModel getVersaoModel() {
		if(versaoModel==null) {
			versaoModel = new VersaoModel();
		}
		return versaoModel;
	}

	public String merge() {
		AudVersaoVO aud = new AudVersaoVO();
		VersaoVO v =  versaoBusiness.findId(versaoModel.getCodigo());
		aud.setVersao(v);
		if(!versaoModel.getData().equals(v.getData())) {
			aud.setNomColuna("data");
			aud.setConteudoAntigo(v.getData().toString());
			aud.setConteudoNovo(versaoModel.getData().toString());
		}
		else if(!versaoModel.getIndLiberado().equals(v.getIndLiberado())) {
			aud.setNomColuna("indLiberado");
			aud.setConteudoAntigo(v.getIndLiberado());
			aud.setConteudoNovo(versaoModel.getIndLiberado());
		}
		else if(!versaoModel.getIndSituacao().equals(v.getIndSituacao())) {
			aud.setNomColuna("indSituacao");
			aud.setConteudoAntigo(v.getIndSituacao());
			aud.setConteudoNovo(versaoModel.getIndSituacao());
		}
		else if(!versaoModel.getNumero().equals(v.getNumero())) {
			aud.setNomColuna("numero");
			aud.setConteudoAntigo(v.getNumero());
			aud.setConteudoNovo(versaoModel.getNumero());
		}
		
		versaoBusiness.edit(preparaVersao(versaoModel));
		
		audVersaoBusiness.saveAud(aud);
		
		return "/manter";
	}
	
	public void setVersaoModel(VersaoModel versaoModel) {
		this.versaoModel = versaoModel;
	}

	public List<ItemVO> getListVersaoItem() {
		return itemBusiness.listVersaoItem();
	}
	
	public List<ItemVO> getListVersaoItemConsultar() {
		return itemBusiness.listVersaoItemConsultar(preparaVersao(versaoModel));
	}
	
	public void consultarVersao() {
		getListVersaoItemConsultar();
		
	}
	
	public void remover(Long idVersao) {
		versaoBusiness.remover(idVersao);
	}
	
	public List<ItemVO> getListItem() {
		return itemBusiness.listItemVO();
	}
	
	private VersaoVO preparaVersao(VersaoModel versaoModel) {
		VersaoVO versaoVO = new VersaoVO();
		
		versaoVO.setData(versaoModel.getData());
		versaoVO.setIndLiberado(versaoModel.getIndLiberado());
		versaoVO.setIndSituacao(versaoModel.getIndSituacao());
		versaoVO.setNumero(versaoModel.getNumero());
		if(versaoModel.getListItemVO()!=null) {
			versaoVO.setItens(addList(versaoModel.getListItemVO()));
		}
		return versaoVO;
	}

	private List<ItemVO> addList(ItemVO[] listItemVO) {
		List<ItemVO> list = new ArrayList<ItemVO>();
		for (ItemVO itemVO : listItemVO) {
			if(itemVO!=null) {
				list.add(itemVO);
			}
		}
		return list;
	}

	public void saveItem() {
		ItemVO item = new ItemVO();
		item.setTitulo(versaoModel.getItem().getTitulo());
		item.setDescricao(versaoModel.getItem().getDescricao());
		itemBusiness.saveIntem(item);
		versaoModel.setItem(null);
	}
	
}
