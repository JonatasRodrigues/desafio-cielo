package br.com.gft.desafio_cielo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.desafio_cielo.config.MensagemConfig;
import br.com.gft.desafio_cielo.constants.ApplicationConstants;
import br.com.gft.desafio_cielo.dto.LancamentoDTO;
import br.com.gft.desafio_cielo.dto.TotaisLancamentosDTO;
import br.com.gft.desafio_cielo.service.LancamentoService;

@RestController
@RequestMapping("/api/v1")
public class LancamentoController {

	private static final Logger logger = LogManager.getLogger(LancamentoController.class);

	@Autowired
	private LancamentoService lancamentoService;
	
	@GetMapping("lancamentos")
	public ResponseEntity<List<LancamentoDTO>> listar() {
		logger.info("Listando todos os lançamentos");
		return new ResponseEntity<List<LancamentoDTO>>(LancamentoDTO.converterTo(lancamentoService.findAll()), HttpStatus.OK);
	}
	
	@GetMapping("lancamentos/{id}")
	public ResponseEntity<LancamentoDTO> buscarPorId(@PathVariable Integer id) {
		logger.info("Buscando lancamento por Id: {}", id);
		return new ResponseEntity<LancamentoDTO>(LancamentoDTO.converterTo(lancamentoService.findById(id)), HttpStatus.OK);
	}

	@DeleteMapping("lancamentos/{id}")
	public ResponseEntity<String> deletar(@PathVariable Integer id) {
		logger.info("Removendo lancamento {} ", id);

		lancamentoService.delete(id);
		
		return new ResponseEntity<String>(MensagemConfig.getMensagem(ApplicationConstants.MSG_REMOVIDO_SUCESSO), HttpStatus.OK);
	}
	
	@GetMapping("lancamentos/totais")
	public ResponseEntity<TotaisLancamentosDTO> calcularTotais() {
		logger.info("Calcular totais lancamentos");
		return new ResponseEntity<TotaisLancamentosDTO>(lancamentoService.calcularTotais(), HttpStatus.OK);
	}
}
