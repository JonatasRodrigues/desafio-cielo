package br.com.gft.desafio_cielo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.desafio_cielo.config.MensagemConfig;
import br.com.gft.desafio_cielo.constants.ApplicationConstants;
import br.com.gft.desafio_cielo.dao.LancamentoDAO;
import br.com.gft.desafio_cielo.dto.TotaisLancamentosDTO;
import br.com.gft.desafio_cielo.entity.Lancamento;
import br.com.gft.desafio_cielo.exception.LancamentoNotFoundException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoDAO lancamentoDAO;
	
	public List<Lancamento> findAll(){
		return lancamentoDAO.findAll();
	}
	
	public Lancamento findById(Integer id){
		return lancamentoDAO.findById(id)
            .orElseThrow(() -> new LancamentoNotFoundException(MensagemConfig.getMensagem(ApplicationConstants.MSG_NAO_ENCONTRADO) + id));
	}
	
	public void delete(Integer id) {
		lancamentoDAO.delete(findById(id));
	}
	
	public TotaisLancamentosDTO calcularTotais() {
		return lancamentoDAO.calcularTotais();
	}
}
