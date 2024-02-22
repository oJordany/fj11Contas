package br.com.caelum.contas;

import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.Tributavel;

public class TestaTributavel {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente();
		cc.deposita(100);
		
		System.out.println(cc.getValorImposto()); // Me traz o imposto da Conta Corrente
												  // Ela implementa a interface Tributavel
		
		//testando polimorfismo
		Tributavel t = cc; // Posso, portanto, me referenciar a cc como um Tributavel
		System.out.println(t.getValorImposto());
	}
}
