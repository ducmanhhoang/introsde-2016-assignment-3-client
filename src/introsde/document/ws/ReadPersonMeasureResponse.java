
package introsde.document.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readPersonMeasureResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readPersonMeasureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measureResult" type="{http://ws.document.introsde/}measureBean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPersonMeasureResponse", propOrder = {
    "measureResult"
})
public class ReadPersonMeasureResponse {

    protected MeasureBean measureResult;

    /**
     * Gets the value of the measureResult property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureBean }
     *     
     */
    public MeasureBean getMeasureResult() {
        return measureResult;
    }

    /**
     * Sets the value of the measureResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureBean }
     *     
     */
    public void setMeasureResult(MeasureBean value) {
        this.measureResult = value;
    }

}
