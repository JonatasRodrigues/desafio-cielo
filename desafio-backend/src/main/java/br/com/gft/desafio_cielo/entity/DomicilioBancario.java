package br.com.gft.desafio_cielo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domicilio_bancario")
public class DomicilioBancario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dbo_id")
	private Integer codigoBanco;

	@Column(name = "dbo_num_agencia")
	private Integer numeroAgencia;

	@Column(name = "dbo_num_conta_corrente")
	private String numeroContaCorrente;

	@Column(name = "dbo_nm_banco")
	private String nomeBanco;
	
	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(String numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

}
