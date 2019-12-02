package br.com.gft.desafio_cielo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gft.desafio_cielo.dto.TotaisLancamentosDTO;
import br.com.gft.desafio_cielo.entity.Lancamento;

@Repository
public interface LancamentoDAO extends JpaRepository<Lancamento,Integer> {

	@Query(value=" select new br.com.gft.desafio_cielo.dto.TotaisLancamentosDTO(count(l.id),"
			+ " sum(r.valorLancamentoRemessa), sum(r.quantidadeLancamentoRemessa))"
			+ " from Lancamento l"
			+ " inner join Remessa r on l.remessa.id = r.id ")
	 TotaisLancamentosDTO calcularTotais();
}
