package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements Tributavel{
	public String getTipo() {
		return "Conta Corrente"; 
	}
	
	public void saca(double valor){
		try{
        	super.saca(valor);
        	this.saldo -= 0.10;
        }catch (SaldoInsuficienteException e) {
        	System.out.println(e.getMessage());
        }
    }
	
	public double getValorImposto() {
		return this.getSaldo() * 0.01;
	}
}
