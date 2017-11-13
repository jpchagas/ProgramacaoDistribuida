package br.pucrs.distribuida.enums;


/**
 * @author joao
 *
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
