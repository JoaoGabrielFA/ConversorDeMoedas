package br.com.conversor_de_moedas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class Conversor {
	
	public static double converter(String primeiraMoeda, String segundaMoeda, double valor) {
		try {
			URL api = new URL("https://economia.awesomeapi.com.br/last/" + primeiraMoeda + "-" + segundaMoeda);
			BufferedReader leitor = new BufferedReader(new InputStreamReader(api.openStream()));
			StringBuilder resposta = new StringBuilder();
			String line;
			
			while ((line = leitor.readLine()) != null) {
				resposta.append(line);
			}
			
			leitor.close();
			
			JSONObject json = new JSONObject(resposta.toString());
			JSONObject usdBrl = json.getJSONObject(primeiraMoeda+segundaMoeda);
			String bid = usdBrl.getString("bid");
			valor = valor * Double.parseDouble(bid);
      
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, "Ocorreu um erro: " + primeiraMoeda + " + " + segundaMoeda + " não é uma operação valida." );
			System.exit(0);
		}
		return valor;
	}
}
