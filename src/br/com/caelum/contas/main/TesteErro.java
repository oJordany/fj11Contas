package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.ContaCorrente;

public class TesteErro {
	public static void main(String[] args) {
		System.out.println("inicio do main");
		try {
			metodo1();
		}catch (NullPointerException e) {
			System.out.println("erro: "+ e);
		}
		System.out.println("fim do main");
	}
	
	static public void metodo1() {
		System.out.println("inicio do metodo1");
//		try {
			metodo2();
//		}catch(NullPointerException e) {
//			System.out.println("erro: "+ e);
//		}
		System.out.println("fim do metodo1");
	}
	
	static public void metodo2() {
		System.out.println("inicio do metodo2");
		ContaCorrente cc = new ContaCorrente();
//		try{
			for (int i = 0; i <= 15; i++) {
//				try {
					cc.deposita(i + 1000);
					System.out.println(cc.getSaldo());
					if (i == 5) {
						cc = null; // Na próxima que ele tentar acessar, cc vai ser null
					}
//				}catch (NullPointerException e) {
//					System.out.println("erro: "+ e);
//				}
			}
//		}catch(NullPointerException e) {
//			System.out.println("erro: "+ e);
//		}
		System.out.println("fim do metodo2");
	}
}