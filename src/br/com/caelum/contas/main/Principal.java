package br.com.caelum.contas.main;
import br.com.caelum.contas.exceptions.SaldoInsuficienteException;
import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class Principal {
	public static void main(String[] args) {
		Conta conta = new ContaCorrente();
		Conta outraConta = new ContaCorrente();
		conta.setAgencia("BB");
		outraConta.setAgencia("BB");
		conta.setNumero(1234);
		outraConta.setNumero(1234);
		
		System.out.println(conta.equals(outraConta));
		
		System.out.println("Conta: " + conta);
		try {
			conta.deposita(-100.0);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(conta.getSaldo());
		try {
			conta.saca(800);
		}catch(SaldoInsuficienteException e) {
			System.out.println("erro: " + e.getMessage());
		}
	}
}
