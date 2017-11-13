package br.pucrs.distribuida.enums;
/**
 * 
 */

/**
 * @author joao
 *
 */
public enum JogadasEnum {
	 DiagonalEsquerdaSuperior(0),
	 Cima(1),
	 DiagonlaDireitaSuperior(2),
	 Esquerda(3),
	 SemMovimento(4),
	 Direita(5),
	 DiagonalEsquerdaInferior(6),
	 Baixo(7),
	 DiagonalDireitaInferior(8);
	
	public int valor;
    JogadasEnum(int valor) {
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
}
