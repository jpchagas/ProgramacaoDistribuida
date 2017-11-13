
package br.distribuida.ct.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de movePeca complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="movePeca">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numCasas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orient" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movePeca", propOrder = {
    "id",
    "pos",
    "sent",
    "numCasas",
    "orient"
})
public class MovePeca {

    protected int id;
    protected int pos;
    protected int sent;
    protected int numCasas;
    protected int orient;

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade pos.
     * 
     */
    public int getPos() {
        return pos;
    }

    /**
     * Define o valor da propriedade pos.
     * 
     */
    public void setPos(int value) {
        this.pos = value;
    }

    /**
     * Obtém o valor da propriedade sent.
     * 
     */
    public int getSent() {
        return sent;
    }

    /**
     * Define o valor da propriedade sent.
     * 
     */
    public void setSent(int value) {
        this.sent = value;
    }

    /**
     * Obtém o valor da propriedade numCasas.
     * 
     */
    public int getNumCasas() {
        return numCasas;
    }

    /**
     * Define o valor da propriedade numCasas.
     * 
     */
    public void setNumCasas(int value) {
        this.numCasas = value;
    }

    /**
     * Obtém o valor da propriedade orient.
     * 
     */
    public int getOrient() {
        return orient;
    }

    /**
     * Define o valor da propriedade orient.
     * 
     */
    public void setOrient(int value) {
        this.orient = value;
    }

}
