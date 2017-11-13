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
public enum RespostasTemPartidaEnum {

	TempoEsperaEsgotado(-2),
	Erro(-1),
	AindaSemPartida(0),
	TemPartidaP1(1),
	TemPartidaP2(2);
	
	public int valor;
	RespostasTemPartidaEnum(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}
