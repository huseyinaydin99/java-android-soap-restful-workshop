package tr.com.huseyinaydin;

//بسم الله الرحمن الرحيم

/**
*
* @author Huseyin_Aydin
* @since 1994
* @category Java, Android, WebServis, SOAP.
*
*/

public class SelamWS {
	public String selamVer(String adiSoyadi) {
		return "Selamlar " + adiSoyadi + " kardeş";
	}

	public String selamVerIkiParametreli(String unvani, String adiSoyadi) {
		return unvani + " Sayın " + adiSoyadi + " saygılar efenim.";
	}

	public String selamVerUcParametreli(String unvani, String adiSoyadi, String yasi) {
		return unvani + " Sayın " + adiSoyadi + " siz " + yasi + " yaşındasınız.";
	}
}