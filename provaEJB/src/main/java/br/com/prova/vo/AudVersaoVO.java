package br.com.prova.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(schema="prova",name="AUD_VERSAO")
@Entity
public class AudVersaoVO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="COD_AUD_VERSAO") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="NOM_COLUNA")
	private String nomColuna;
	
	@Column(name="CONTEUDO_ANTIGO")
	private String conteudoAntigo;
	
	@Column(name="CONTEUDO_NOVO")
	private String conteudoNovo;
	
	@ManyToOne
	@JoinColumn(name="NOM_LOGIN", referencedColumnName="NOM_LOGIN")
	private LoginVO login;
	
	@ManyToOne
	@JoinColumn(name="COD_VERSAO", referencedColumnName="COD_VERSAO")
	private VersaoVO versao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomColuna() {
		return nomColuna;
	}

	public void setNomColuna(String nomColuna) {
		this.nomColuna = nomColuna;
	}

	public String getConteudoAntigo() {
		return conteudoAntigo;
	}

	public void setConteudoAntigo(String conteudoAntigo) {
		this.conteudoAntigo = conteudoAntigo;
	}

	public String getConteudoNovo() {
		return conteudoNovo;
	}

	public void setConteudoNovo(String conteudoNovo) {
		this.conteudoNovo = conteudoNovo;
	}

	public LoginVO getLogin() {
		return login;
	}

	public void setLogin(LoginVO login) {
		this.login = login;
	}

	public VersaoVO getVersao() {
		return versao;
	}

	public void setVersao(VersaoVO versao) {
		this.versao = versao;
	}

	
}
