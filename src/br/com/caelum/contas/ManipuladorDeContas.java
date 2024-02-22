package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas {
	
	private Conta conta;
	
	public void criaConta(Evento evento) {
//		this.conta = new Conta();
		String agencia = evento.getString("agencia");
		int numero = evento.getInt("numero");
		String titular = evento.getString("titular");
		String tipo = evento.getSelecionadoNoRadio("tipo");
		
		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		}else if (tipo.equals("Conta Poupança")) {
			this.conta = new ContaPoupanca();
		}
		
		this.conta.setAgencia(agencia);
		this.conta.setNumero(numero);
		this.conta.setTitular(titular);
		
		
	}
	
	public void deposita(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.deposita(valorDigitado);
	}
	
	public void saca(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.saca(valorDigitado);
	}
	
	public void transfere(Evento evento) {
		double valorDigitado = evento.getDouble("valorTransferencia");
		this.conta.transfere(valorDigitado, (Conta) evento.getSelecionadoNoCombo("destino"));
	}
}
