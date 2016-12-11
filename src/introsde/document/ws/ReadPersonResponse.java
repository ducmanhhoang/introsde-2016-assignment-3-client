
package introsde.document.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readPersonResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personResult" type="{http://ws.document.introsde/}personBean2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonResponse", propOrder = {
    "personResult"
})
public class ReadPersonResponse {

    protected PersonBean2 personResult;

    /**
     * Gets the value of the personResult property.
     * 
     * @return
     *     possible object is
     *     {@link PersonBean2 }
     *     
     */
    public PersonBean2 getPersonResult() {
        return personResult;
    }

    /**
     * Sets the value of the personResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonBean2 }
     *     
     */
    public void setPersonResult(PersonBean2 value) {
        this.personResult = value;
    }

}
