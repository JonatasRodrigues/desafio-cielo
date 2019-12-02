package br.com.gft.desafio_cielo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_operacao")
public class TipoOperacao {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "top_id")
	private Integer id;
	
	@Column(name = "top_descricao")
	private String nomeTipoOperacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTipoOperacao() {
		return nomeTipoOperacao;
	}

	public void setNomeTipoOperacao(String nomeTipoOperacao) {
		this.nomeTipoOperacao = nomeTipoOperacao;
	}

}
