package br.pucrs.distribuida.enums;


/**
 * @author joao
 *
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
