package br.com.conversor_de_moedas;

import java.awt.Dimension;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,200)); 
		
		ConversorDeMoedas.iniciar();
	}

}
