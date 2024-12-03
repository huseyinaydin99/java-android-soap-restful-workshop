/**
 * 
 */
package tr.com.huseyinaydin;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//بسم الله الرحمن الرحيم

/**
*
* @author Huseyin_Aydin
* @since 1994
* @category Java, Android, WebServis, RESTful.
*
*/

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="musteri")
public class Musteri implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="id")
	private int musteriId;
	
	@XmlElement(name="adisoyadi")
	private String musteriAdiSoyadi;
	
	@XmlElement(name="bilgi")
	private String musteriBilgi;
	
	/*
	<musteri>
		<id>1</id>
		<adisoyadi>Hüseyin AYDIN</adisoyadi>
		<bilgi>Java Developer</bilgi>
	</musteri>
	*/
	
	public int getMusteriId() {
		return musteriId;
	}
	
	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}
	
	
	public String getMusteriAdiSoyadi() {
		return musteriAdiSoyadi;
	}
	
	public void setMusteriAdiSoyadi(String musteriAdiSoyadi) {
		this.musteriAdiSoyadi = musteriAdiSoyadi;
	}
	
	
	public String getMusteriBilgi() {
		return musteriBilgi;
	}
	
	public void setMusteriBilgi(String musteriBilgi) {
		this.musteriBilgi = musteriBilgi;
	}
}