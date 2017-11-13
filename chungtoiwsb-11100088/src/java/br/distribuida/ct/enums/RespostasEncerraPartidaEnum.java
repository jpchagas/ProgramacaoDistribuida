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
public enum RespostasEncerraPartidaEnum {

	Erro(-1),
	Ok(0);
	
	public int valor;
	RespostasEncerraPartidaEnum(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}
