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
public enum RespostasPosicionaPecaEnum {

	NaoEVez(-3),
	PartidaNaoIniciada(-2),
	ParâmetrosInválidos(-1),
	PosicaoInvalida(0),
	TudoCerto(1),
	PartidaEncerrada(2);
	
	public int valor;
	RespostasPosicionaPecaEnum(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}
