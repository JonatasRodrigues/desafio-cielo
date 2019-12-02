package br.com.gft.desafio_cielo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "situacao_remessa")
public class SituacaoRemessa {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sre_id")
	private Integer id;
	
	@Column(name = "sre_descricao")
	private String nomeSituacaoRemessa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeSituacaoRemessa() {
		return nomeSituacaoRemessa;
	}

	public void setNomeSituacaoRemessa(String nomeSituacaoRemessa) {
		this.nomeSituacaoRemessa = nomeSituacaoRemessa;
	}
	
	
}
