
package br.distribuida.ct.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de preRegistro complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="preRegistro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nome1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nome2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preRegistro", propOrder = {
    "id1",
    "nome1",
    "id2",
    "nome2"
})
public class PreRegistro {

    protected int id1;
    protected String nome1;
    protected int id2;
    protected String nome2;

    /**
     * Obtém o valor da propriedade id1.
     * 
     */
    public int getId1() {
        return id1;
    }

    /**
     * Define o valor da propriedade id1.
     * 
     */
    public void setId1(int value) {
        this.id1 = value;
    }

    /**
     * Obtém o valor da propriedade nome1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome1() {
        return nome1;
    }

    /**
     * Define o valor da propriedade nome1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome1(String value) {
        this.nome1 = value;
    }

    /**
     * Obtém o valor da propriedade id2.
     * 
     */
    public int getId2() {
        return id2;
    }

    /**
     * Define o valor da propriedade id2.
     * 
     */
    public void setId2(int value) {
        this.id2 = value;
    }

    /**
     * Obtém o valor da propriedade nome2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome2() {
        return nome2;
    }

    /**
     * Define o valor da propriedade nome2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome2(String value) {
        this.nome2 = value;
    }

}
