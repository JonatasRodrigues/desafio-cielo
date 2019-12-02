package br.com.gft.desafio_cielo.exception;

public class LancamentoNotFoundException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public LancamentoNotFoundException(String msg) {
        super(msg);
    }

}
