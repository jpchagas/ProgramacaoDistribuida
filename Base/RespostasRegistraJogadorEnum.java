package br.pucrs.distribuida.enums;


/**
 * @author joao
 *
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
