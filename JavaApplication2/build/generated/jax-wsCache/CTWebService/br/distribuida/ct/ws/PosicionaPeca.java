
package br.distribuida.ct.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de posicionaPeca complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="posicionaPeca">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pos" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "posicionaPeca", propOrder = {
    "id",
    "pos",
    "orient"
})
public class PosicionaPeca {

    protected int id;
    protected int pos;
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
