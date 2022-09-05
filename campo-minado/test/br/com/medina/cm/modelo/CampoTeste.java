package br.com.medina.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.medina.cm.excecao.ExplosaoException;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	void inciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testeVizinhoDistancia1() {
		Campo vizinhoEsquerda = new Campo(3, 2);
		boolean resultadoEsquerda = campo.adicionarVizinho(vizinhoEsquerda);

		Campo vizinhoDireita = new Campo(3, 2);
		boolean resultadoDireita = campo.adicionarVizinho(vizinhoDireita);

		Campo vizinhoEmcima = new Campo(2, 3);
		boolean resultadoEmcima = campo.adicionarVizinho(vizinhoEmcima);

		Campo vizinhoEmbaixo = new Campo(4, 3);
		boolean resultadoEmbaixo = campo.adicionarVizinho(vizinhoEmbaixo);
		
		assertTrue(resultadoEsquerda);
		assertTrue(resultadoDireita);
		assertTrue(resultadoEmcima);
		assertTrue(resultadoEmbaixo);
	}
	
	@Test
	void testeVizinhoDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeNaoVizinhoDistancia2() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testarAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

	@Test
	void testarValorPadraoAtributoMarcacado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testarAlternarMarcacaoDuasChamadas() {
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
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () ->{
			campo.abrir();
		});
	}

	@Test
	void testeAbrirComVizinhos() {
		Campo vizinho1 = new Campo(2, 2);
		Campo vizinhoDoVizinho1 = new Campo(2, 3);
		
		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		campo.adicionarVizinho(vizinho1);
		
		campo.abrir();
		assertTrue(vizinho1.isAberto() && vizinhoDoVizinho1.isAberto());
	}
}
