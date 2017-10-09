package br.com.prova.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Table(schema="prova",name="VERSAO")
@Entity	
public class VersaoVO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="COD_VERSAO") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	@Column(name="NRO_VERSAO",length=10,nullable=false) 
	private String numero;
	@Column(name="DAT_VERSAO",nullable=true) 
	private Date data;
	@Column(name="IND_LIBERADO",length=10,nullable=false) 
	private String indLiberado;
	@Column(name="IND_SITUACAO",length=10,nullable=false) 
	private String indSituacao;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "VERSAO_ITEM",schema="prova", 
			   joinColumns = { @JoinColumn(name = "COD_VERSAO") }, 
			   inverseJoinColumns = { @JoinColumn(name = "COD_ITEM") })
	private List<ItemVO> itens = new ArrayList<ItemVO>();
	
	@Transient
	private ItemVO itemVO;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
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
	public List<ItemVO> getItens() {
		if(itens==null) {
			itens = new ArrayList<ItemVO>();
		}
		return itens;
	}
	public void setItens(List<ItemVO> itens) {
		this.itens = itens;
	}
	public ItemVO getItemVO() {
		return itemVO;
	}
	public void setItemVO(ItemVO itemVO) {
		this.itemVO = itemVO;
	}
	
	
}
