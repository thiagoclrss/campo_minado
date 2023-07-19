package br.com.meucurso.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<>();

	
	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		gerarCampos();
		associarVizinhos();
		sortearMinas();	
	}


	private void sortearMinas() {
		// TODO Auto-generated method stub
		
	}


	private void associarVizinhos() {
		for(int linha = 0; linha < linhas; linha++) {
			for(int coluna = 0; coluna < colunas; coluna++) {
				campos.add(new Campo(linha, coluna));
			}
		}
		
	}


	private void gerarCampos() {
		for(Campo c1: campos) {
			for(Campo c2: campos) {
				c1.adicionarVizinhos(c2);
			} 
		}
		
	}
	
	
}
