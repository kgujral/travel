//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.13 at 11:48:35 PM IST 
//


package in.theqwerty.travel.flight.beans.xml.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaxTypeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaxTypeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="ADT"/>
 *     &lt;enumeration value="CHD"/>
 *     &lt;enumeration value="INF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaxTypeEnumType")
@XmlEnum
public enum PaxTypeEnumType {

    ADT,
    CHD,
    INF;

    public String value() {
        return name();
    }

    public static PaxTypeEnumType fromValue(String v) {
        return valueOf(v);
    }

}