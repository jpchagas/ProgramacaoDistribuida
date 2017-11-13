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
public enum RespostasMinhaVezEnum {

	NaoHaDoisJogadores(-2),
	Erro(-1),
	Nao(0),
	Sim(1),
	Vencedor(2),
	Perdedor(3),
	Empate(4),
	VencedorWO(5),
	PerdedorWO(6);
	
	public int valor;
	RespostasMinhaVezEnum(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}
