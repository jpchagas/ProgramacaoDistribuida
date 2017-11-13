package br.pucrs.distribuida.enums;


/**
 * @author joao
 *
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
