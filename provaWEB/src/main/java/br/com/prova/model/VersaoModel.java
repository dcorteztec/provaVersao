package br.com.prova.model;

import java.util.Date;

import javax.faces.bean.SessionScoped;

import br.com.prova.vo.ItemVO;

@SessionScoped
public class VersaoModel {

	private Long codigo;
	private String numero;
	private Date data; 
	private String indLiberado;
	private String indSituacao;
	private ItemModel item;
	private ItemVO[] listItemVO;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getIndLiberado() {
		return indLiberado;
	}
	public void setIndLiberado(String indLiberado) {
		this.indLiberado = indLiberado;
	}
	public String getIndSituacao() {
		return indSituacao;
	}
	public void setIndSituacao(String indSituacao) {
		this.indSituacao = indSituacao;
	}
	public ItemModel getItem() {
		if(item==null) {
			item = new ItemModel();
		}
		return item;
	}
	public void setItem(ItemModel item) {
		this.item = item;
	}
	public ItemVO[] getListItemVO() {
		return listItemVO;
	}
	public void setListItemVO(ItemVO[] listItemVO) {
		this.listItemVO = listItemVO;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	
	
}
