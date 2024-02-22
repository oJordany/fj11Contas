package br.com.caelum.contas.exceptions;

public class SaldoInsuficienteException extends RuntimeException{

	public SaldoInsuficienteException(String message) {
		super(message);
	}
}
