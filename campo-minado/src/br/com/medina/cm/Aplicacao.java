package br.com.medina.cm;

import br.com.medina.cm.modelo.Tabuleiro;
import br.com.medina.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
	}
}
