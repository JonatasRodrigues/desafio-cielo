package br.com.gft.desafio_cielo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "remessa")
public class Remessa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rem_id")
	private Integer id;

	@Column(name = "rem_num_remessa")
	private Long numeroRemessaBanco;

	@ManyToOne
	@JoinColumn(name = "sre_id")
	private SituacaoRemessa situacaoRemessa;

	@Column(name = "rem_qtd_remessa")
	private Integer quantidadeLancamentoRemessa;

	@Column(name = "rem_vlr_remessa")
	private BigDecimal valorLancamentoRemessa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNumeroRemessaBanco() {
		return numeroRemessaBanco;
	}

	public void setNumeroRemessaBanco(Long numeroRemessaBanco) {
		this.numeroRemessaBanco = numeroRemessaBanco;
	}

	public SituacaoRemessa getSituacaoRemessa() {
		return situacaoRemessa;
	}

	public void setSituacaoRemessa(SituacaoRemessa situacaoRemessa) {
		this.situacaoRemessa = situacaoRemessa;
	}

	public Integer getQuantidadeLancamentoRemessa() {
		return quantidadeLancamentoRemessa;
	}

	public void setQuantidadeLancamentoRemessa(Integer quantidadeLancamentoRemessa) {
		this.quantidadeLancamentoRemessa = quantidadeLancamentoRemessa;
	}

	public BigDecimal getValorLancamentoRemessa() {
		return valorLancamentoRemessa;
	}

	public void setValorLancamentoRemessa(BigDecimal valorLancamentoRemessa) {
		this.valorLancamentoRemessa = valorLancamentoRemessa;
	}

}
