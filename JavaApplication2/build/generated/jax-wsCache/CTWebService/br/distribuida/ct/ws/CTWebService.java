
package br.distribuida.ct.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CTWebService", targetNamespace = "http://ws.ct.distribuida.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CTWebService {


    /**
     * 
     * @param nome
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "registraJogador", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.RegistraJogador")
    @ResponseWrapper(localName = "registraJogadorResponse", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.RegistraJogadorResponse")
    @Action(input = "http://ws.ct.distribuida.br/CTWebService/registraJogadorRequest", output = "http://ws.ct.distribuida.br/CTWebService/registraJogadorResponse")
    public int registraJogador(
        @WebParam(name = "nome", targetNamespace = "")
        String nome);

    /**
     * 
     * @param id
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encerraPartida", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.EncerraPartida")
    @ResponseWrapper(localName = "encerraPartidaResponse", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.EncerraPartidaResponse")
    @Action(input = "http://ws.ct.distribuida.br/CTWebService/encerraPartidaRequest", output = "http://ws.ct.distribuida.br/CTWebService/encerraPartidaResponse")
    public int encerraPartida(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "temPartida", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.TemPartida")
    @ResponseWrapper(localName = "temPartidaResponse", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.TemPartidaResponse")
    @Action(input = "http://ws.ct.distribuida.br/CTWebService/temPartidaRequest", output = "http://ws.ct.distribuida.br/CTWebService/temPartidaResponse")
    public int temPartida(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtemOponente", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.ObtemOponente")
    @ResponseWrapper(localName = "obtemOponenteResponse", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.ObtemOponenteResponse")
    @Action(input = "http://ws.ct.distribuida.br/CTWebService/obtemOponenteRequest", output = "http://ws.ct.distribuida.br/CTWebService/obtemOponenteResponse")
    public String obtemOponente(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtemTabuleiro", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.ObtemTabuleiro")
    @ResponseWrapper(localName = "obtemTabuleiroResponse", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.ObtemTabuleiroResponse")
    @Action(input = "http://ws.ct.distribuida.br/CTWebService/obtemTabuleiroRequest", output = "http://ws.ct.distribuida.br/CTWebService/obtemTabuleiroResponse")
    public String obtemTabuleiro(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param orient
     * @param pos
     * @param id
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "posicionaPeca", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.PosicionaPeca")
    @ResponseWrapper(localName = "posicionaPecaResponse", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.PosicionaPecaResponse")
    @Action(input = "http://ws.ct.distribuida.br/CTWebService/posicionaPecaRequest", output = "http://ws.ct.distribuida.br/CTWebService/posicionaPecaResponse")
    public int posicionaPeca(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "pos", targetNamespace = "")
        int pos,
        @WebParam(name = "orient", targetNamespace = "")
        int orient);

    /**
     * 
     * @param orient
     * @param pos
     * @param numCasas
     * @param id
     * @param sent
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "movePeca", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.MovePeca")
    @ResponseWrapper(localName = "movePecaResponse", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.MovePecaResponse")
    @Action(input = "http://ws.ct.distribuida.br/CTWebService/movePecaRequest", output = "http://ws.ct.distribuida.br/CTWebService/movePecaResponse")
    public int movePeca(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "pos", targetNamespace = "")
        int pos,
        @WebParam(name = "sent", targetNamespace = "")
        int sent,
        @WebParam(name = "numCasas", targetNamespace = "")
        int numCasas,
        @WebParam(name = "orient", targetNamespace = "")
        int orient);

    /**
     * 
     * @param id2
     * @param id1
     * @param nome1
     * @param nome2
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "preRegistro", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.PreRegistro")
    @ResponseWrapper(localName = "preRegistroResponse", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.PreRegistroResponse")
    @Action(input = "http://ws.ct.distribuida.br/CTWebService/preRegistroRequest", output = "http://ws.ct.distribuida.br/CTWebService/preRegistroResponse")
    public int preRegistro(
        @WebParam(name = "nome1", targetNamespace = "")
        String nome1,
        @WebParam(name = "id1", targetNamespace = "")
        int id1,
        @WebParam(name = "nome2", targetNamespace = "")
        String nome2,
        @WebParam(name = "id2", targetNamespace = "")
        int id2);

    /**
     * 
     * @param id
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ehMinhaVez", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.EhMinhaVez")
    @ResponseWrapper(localName = "ehMinhaVezResponse", targetNamespace = "http://ws.ct.distribuida.br/", className = "br.distribuida.ct.ws.EhMinhaVezResponse")
    @Action(input = "http://ws.ct.distribuida.br/CTWebService/ehMinhaVezRequest", output = "http://ws.ct.distribuida.br/CTWebService/ehMinhaVezResponse")
    public int ehMinhaVez(
        @WebParam(name = "id", targetNamespace = "")
        int id);

}
