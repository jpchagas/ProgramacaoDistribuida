/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.distribuida.ct.enums;

/**
 *
 * @author joao
 */
public enum JogadasEnum {
	 DiagonalEsquerdaSuperior(0),
	 Cima(1),
	 DiagonlaDireitaSuperior(2),
	 Esquerda(3),
	 SemMovimento(4),
	 Direita(5),
	 DiagonalEsquerdaInferior(6),
	 Baixo(7),
	 DiagonalDireitaInferior(8);
	
	public int valor;
    JogadasEnum(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}

