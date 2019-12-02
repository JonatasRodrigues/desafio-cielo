package br.com.gft.desafio_cielo.dto;

import java.math.BigDecimal;

public class TotaisLancamentosDTO {

	private Long qtdTotalLancamento;
	private Long qtdTotalRemessa;
	private BigDecimal vlrTotalLancamento;

	public TotaisLancamentosDTO(Long qtdTotalLancamento, BigDecimal vlrTotalLancamento, Long qtdTotalRemessa) {
		super();
		this.qtdTotalLancamento = qtdTotalLancamento;
		this.qtdTotalRemessa = qtdTotalRemessa;
		this.vlrTotalLancamento = vlrTotalLancamento;
	}

	public Long getQtdTotalLancamento() {
		return qtdTotalLancamento;
	}

	public Long getQtdTotalRemessa() {
		return qtdTotalRemessa;
	}

	public BigDecimal getVlrTotalLancamento() {
		return vlrTotalLancamento;
	}

}