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
public enum RespostasRegistraJogadorEnum {
	
	UsuárioJaCadastrado(-1),
	NumeroMaximoJogadoresAtingido(-2);
	
	public int valor;
	RespostasRegistraJogadorEnum(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}
