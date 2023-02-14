package br.com.conversor_de_moedas;

import javax.swing.JOptionPane;

public class ConversorDeMoedas {
	
	private static String[] moedas = {"BRL", "USD", "EUR", "GBP", "JNY", "KRW", "ARS", "Outra Moeda"};
	private static String[] moedas2 = new String[7];
	private static String primeiraMoeda; 
	private static String segundaMoeda;
	
	public static void iniciar() {
		try {
			converter();
		} catch (NullPointerException e) {
			JOptionPane.showInternalMessageDialog(null, "Programa Concluído");
			System.exit(0);
		}
	}
	
	public static void converter() {
		double valorConvertido = Conversor.converter(escolherPrimeiraMoeda(), escolherSegundaMoeda(), digitarValor()); 
		JOptionPane.showMessageDialog(null, "O valor convertido em " + segundaMoeda + " é " + String.format("%.2f", valorConvertido));
		continuar();
	}
	
	private static String escolherPrimeiraMoeda() {
		String moeda = (JOptionPane.showInputDialog(null, "Escolha qual moeda você quer converter:", "Moedas", JOptionPane.PLAIN_MESSAGE, null, moedas, "Escolha").toString());
		if (moeda.equals("Outra Moeda")) {
			moeda = JOptionPane.showInputDialog(null, "Digite a moeda que você quer usar:");
			moeda = moeda.toUpperCase();
			moedas2 = moedas;
		}else {
			excluirMoedaEscolhida(moeda);
		}
		primeiraMoeda = moeda;
		return primeiraMoeda;		
	}
	
	private static String escolherSegundaMoeda() {
		String moeda = (JOptionPane.showInputDialog(null, "Escolha a moeda para qual você quer converter seu dinheiro:", "Moedas", JOptionPane.PLAIN_MESSAGE, null, moedas2, "Escolha").toString());
		if (moeda.equals("Outra Moeda")) {
			moeda = JOptionPane.showInputDialog(null, "Digite a moeda que você quer usar:");
			moeda = moeda.toUpperCase();
		}
		segundaMoeda = moeda;
		return segundaMoeda;
	}
	
	private static void excluirMoedaEscolhida(String moeda) {
		boolean achou = false;
		
		for(int i = 0; i < moedas.length - 1; i++) {
			if(moeda != moedas[i] && !achou) {
				moedas2[i] = moedas[i];
			} else {
				moedas2[i] = moedas[i+1];
				achou = true;
			}
		}
	}
	
	private static double digitarValor(){
		double valor;
		try {
			valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor em " + primeiraMoeda + " que será convertido em " + segundaMoeda + ":"));
		} catch (NumberFormatException e) {
			JOptionPane.showInternalMessageDialog(null, "Você precisa digitar um valor!");
			valor = digitarValor();
		}
		return valor;
	} 
	
	private static int continuar() {
		int desejaContinuar = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
		if(JOptionPane.OK_OPTION == desejaContinuar) {
			converter();
		} else if(JOptionPane.NO_OPTION == desejaContinuar){
			JOptionPane.showInternalMessageDialog(null, "Programa Finalizado");
		} else {
			JOptionPane.showInternalMessageDialog(null, "Programa Concluído");
		}
		return desejaContinuar;
	}
}
