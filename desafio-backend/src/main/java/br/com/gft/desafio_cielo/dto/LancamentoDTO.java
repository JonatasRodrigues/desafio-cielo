package br.com.gft.desafio_cielo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.gft.desafio_cielo.entity.DomicilioBancario;
import br.com.gft.desafio_cielo.entity.Lancamento;

public class LancamentoDTO {

	private Integer id;
	private String descricao;
	private Long numero;
	private String situacao;
	private String dadosBancarios;
	private BigDecimal vlrFinal;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtLancamento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtConfirmacao;
	
	public static List<LancamentoDTO> converterTo(List<Lancamento> lancamentos){
		List<LancamentoDTO> lista = new ArrayList<LancamentoDTO>();
		
		for(Lancamento lancamento : lancamentos) {
			lista.add(converterTo(lancamento));
		}

		return lista;
	}
	
	public static LancamentoDTO converterTo(Lancamento lancamento){

		DomicilioBancario banco = lancamento.getCliente().getDadosDomicilioBancario();
		String dadosBancarios = String.format("%s Ag %d CC %s", banco.getNomeBanco(), banco.getNumeroAgencia(),
				banco.getNumeroContaCorrente());
	
		LancamentoDTO dto = new LancamentoDTO();
		dto.setId(lancamento.getId());
		dto.setDtLancamento(lancamento.getDataLancamentoContaCorrenteCliente());
		dto.setDescricao(lancamento.getTipoOperacao().getNomeTipoOperacao());
		dto.setNumero(lancamento.getRemessa().getNumeroRemessaBanco());
		dto.setDtConfirmacao(lancamento.getDataEfetivaLancamento());
		dto.setSituacao(lancamento.getRemessa().getSituacaoRemessa().getNomeSituacaoRemessa());
		dto.setVlrFinal(lancamento.getRemessa().getValorLancamentoRemessa());
		dto.setDadosBancarios(dadosBancarios);
		
		return dto;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDtLancamento() {
		return dtLancamento;
	}

	public void setDtLancamento(Date dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDtConfirmacao() {
		return dtConfirmacao;
	}

	public void setDtConfirmacao(Date dtConfirmacao) {
		this.dtConfirmacao = dtConfirmacao;
	}

	public String getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(String dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	public BigDecimal getVlrFinal() {
		return vlrFinal;
	}

	public void setVlrFinal(BigDecimal vlrFinal) {
		this.vlrFinal = vlrFinal;
	}

}
