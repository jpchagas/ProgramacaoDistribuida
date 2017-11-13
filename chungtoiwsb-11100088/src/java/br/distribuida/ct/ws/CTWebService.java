/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.distribuida.ct.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import br.distribuida.ct.game.ChungToiImpl;

/**
 *
 * @author joao
 */
@WebService(serviceName = "CTWebService")
public class CTWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "registraJogador")
    public int registraJogador(@WebParam(name = "nome") String nome) {
        ChungToiImpl cti = new ChungToiImpl();
        return cti.registraJogador(nome);
        
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "encerraPartida")
    public int encerraPartida(@WebParam(name = "id") int id) {
        ChungToiImpl cti = new ChungToiImpl();
        return cti.encerraPartida(id);
        
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "temPartida")
    public int temPartida(@WebParam(name = "id") int id) {
        ChungToiImpl cti = new ChungToiImpl();
        return cti.temPartida(id);
        
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "obtemOponente")
    public String obtemOponente(@WebParam(name = "id") int id) {
        ChungToiImpl cti = new ChungToiImpl();
        return cti.obtemOponente(id);
        
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "obtemTabuleiro")
    public String obtemTabuleiro(@WebParam(name = "id") int id) {
        ChungToiImpl cti = new ChungToiImpl();
        return cti.obtemTabuleiro(id);
        
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "posicionaPeca")
    public int posicionaPeca(@WebParam(name = "id") int id, @WebParam(name = "pos") int pos, @WebParam(name = "orient") int orient) {
        ChungToiImpl cti = new ChungToiImpl();
        return cti.posicionaPeca(id, pos, orient);
        
    }

    /**
     * Operação de Web service
     * @param id
     * @param pos
     */
    @WebMethod(operationName = "movePeca")
    public int movePeca(@WebParam(name = "id") int id, @WebParam(name = "pos") int pos, @WebParam(name = "sent") int sent, @WebParam(name = "numCasas") int numCasas, @WebParam(name = "orient") int orient) {
        ChungToiImpl cti = new ChungToiImpl();
        return cti.movePeca(id, pos, sent, numCasas, orient);
        
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "preRegistro")
    public int preRegistro(@WebParam(name = "nome1") String nome1, @WebParam(name = "id1") int id1, @WebParam(name = "nome2") String nome2, @WebParam(name = "id2") int id2) {
        ChungToiImpl cti = new ChungToiImpl();
        return cti.preRegistro(nome1, id1, nome2,id2);
        
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "ehMinhaVez")
    public int ehMinhaVez(@WebParam(name = "id") int id) {
        ChungToiImpl cti = new ChungToiImpl();
        return cti.ehMinhaVez(id);
        
    }
}
