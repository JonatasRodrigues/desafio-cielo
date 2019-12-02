package br.com.gft.desafio_cielo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.gft.desafio_cielo.config.MensagemConfig;
import br.com.gft.desafio_cielo.constants.ApplicationConstants;
import br.com.gft.desafio_cielo.dto.TotaisLancamentosDTO;
import br.com.gft.desafio_cielo.entity.Cliente;
import br.com.gft.desafio_cielo.entity.DomicilioBancario;
import br.com.gft.desafio_cielo.entity.Lancamento;
import br.com.gft.desafio_cielo.entity.Remessa;
import br.com.gft.desafio_cielo.entity.SituacaoRemessa;
import br.com.gft.desafio_cielo.entity.TipoOperacao;
import br.com.gft.desafio_cielo.exception.LancamentoNotFoundException;
import br.com.gft.desafio_cielo.service.LancamentoService;
import mockit.Mock;
import mockit.MockUp;

public class MockLancamentoService extends MockUp<LancamentoService>{

	
	@Mock
	public List<Lancamento> findAll(){
		List<Lancamento> lista = new ArrayList<Lancamento>();
		
		DomicilioBancario banco = new DomicilioBancario();
		banco.setCodigoBanco(1);
		banco.setNomeBanco("ABC");
		banco.setNumeroAgencia(123);
		banco.setNumeroContaCorrente("44444");
		
		TipoOperacao tipo = new TipoOperacao();
		tipo.setId(1);
		tipo.setNomeTipoOperacao("Regular");
		
		SituacaoRemessa situacao = new SituacaoRemessa();
		situacao.setId(1);
		situacao.setNomeSituacaoRemessa("Pago");
		
		Remessa remessa = new Remessa();
		remessa.setId(1);
		remessa.setNumeroRemessaBanco(1234L);
		remessa.setQuantidadeLancamentoRemessa(10);
		remessa.setSituacaoRemessa(situacao);
		remessa.setValorLancamentoRemessa(new BigDecimal(2222));
		
		Cliente cliente = new Cliente();
		cliente.setDadosDomicilioBancario(banco);
		cliente.setId(1);
		cliente.setNumeroRaizCNPJ("4343435454");
		cliente.setNumeroSufixoCNPJ("2234");

		Calendar c = new GregorianCalendar(2019,10,30);
		
		Lancamento lancamento = new Lancamento();
		lancamento.setCliente(cliente);
		lancamento.setCodigoIdentificadorUnico("1");
		lancamento.setDataEfetivaLancamento(c.getTime());
		lancamento.setDataLancamentoContaCorrenteCliente(c.getTime());
		lancamento.setDescricaoGrupoPagamento("G1");
		lancamento.setId(1);
		lancamento.setNumeroEvento(98L);
		lancamento.setRemessa(remessa);
		lancamento.setTipoOperacao(tipo);
		lista.add(lancamento);
		
		return lista;
	}
	
	@Mock
	public Lancamento findById(Integer id){
		List<Lancamento> lista = findAll();
		return lista.stream().filter(n -> n.getId().equals(id)).findFirst()
			 .orElseThrow(() -> new LancamentoNotFoundException(MensagemConfig.getMensagem(ApplicationConstants.MSG_NAO_ENCONTRADO) + id));
	}
	
	@Mock
	public void delete(Integer id){
		findById(id);
	}
	
	@Mock
	public TotaisLancamentosDTO calcularTotais() {
		return new TotaisLancamentosDTO(3L, new BigDecimal(13459.10), 30L);
	}
}
