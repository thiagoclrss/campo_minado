package br.com.meucurso.cm.modelo;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CampoTeste {
	
	private Campo campo = new Campo(3, 3);
	
	@Test
	void testeVizinhoRealEsquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinhos(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDireita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinhos(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealEmCima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinhos(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealEmBaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinhos(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia2Diagonal() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinhos(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinhos(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadonaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinhos() {
		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
		
		campo22.adicionarVizinhos(campo11);
		campo.adicionarVizinhos(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
}
