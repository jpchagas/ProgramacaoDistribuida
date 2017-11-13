package br.pucrs.distribuida.enums;
/**
 * 
 */

/**
 * @author joao
 *
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
