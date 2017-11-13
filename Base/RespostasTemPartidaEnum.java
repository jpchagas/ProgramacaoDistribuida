package br.pucrs.distribuida.enums;


/**
 * @author joao
 *
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
