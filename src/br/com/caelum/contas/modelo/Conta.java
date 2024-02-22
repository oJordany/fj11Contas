package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exceptions.SaldoInsuficienteException;

/**
 * Classe responsável por moldar as Contas do Banco
 *
 * @author Luiz Jordany de Sousa Silva
 */

public abstract class Conta {
	private String titular;
	private int numero;
	private String agencia;
	protected double saldo;
	
	@Override
	public String toString() {
		return 	"[titular=" + titular.toUpperCase() + 
				", numero=" + numero +
				", agencia=" + agencia + "]";
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		
		if (!(object instanceof Conta)) 
			return false;
		
		Conta conta = (Conta) object;
		return (this.numero == conta.numero &&
				this.agencia.equals(conta.agencia));

	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public void saca(double valor){
		/**
		 * Método que decrementa o saldo 
		 * @param valor
		 */
        if (this.saldo < valor){
            throw new SaldoInsuficienteException("Saldo Insuficiente");
        }else{
            this.saldo -= valor;
        }   
    }

    public void deposita(double quantidade){
    	/**
    	 * Método que incrementa o saldo
    	 * @param valor
    	 */
        if (quantidade > 0)
			this.saldo += quantidade;
		else
			throw new IllegalArgumentException("Valor de depósito negativo");
    }
    
    public void transfere(double valorDaTransferencia, Conta contaDeDestino) {
    	try {
    		this.saca(valorDaTransferencia);
    	}catch(SaldoInsuficienteException e) {
    		System.out.println(e.getMessage());
    	}
    	contaDeDestino.deposita(valorDaTransferencia);
    }
    
    public abstract String getTipo();
}
