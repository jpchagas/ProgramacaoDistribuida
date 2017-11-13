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
public enum RespostasMovePecaEnum {

	NaoEVez(-3),
	PartidaNaoIniciada(-2),
	ParâmetrosInválidos(-1),
	MovimentoInvalido(0),
	TudoCerto(1),
	PartidaEncerrada(2);
	
	public int valor;
	RespostasMovePecaEnum(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}
