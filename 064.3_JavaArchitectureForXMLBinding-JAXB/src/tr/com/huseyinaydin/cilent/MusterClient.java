package tr.com.huseyinaydin.cilent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import tr.com.huseyinaydin.Musteri;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android, WebServis, RESTful.
 *
 */

public class MusterClient {

	public static void main(String[] args) {

		try {
			int idDegeri = 11;
			URL url = new URL("http://localhost:8080/_014_JavaArchitectureForXMLBinding-JAXB/rest/market/detay/" + idDegeri);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/xml");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException(" GELEN HTTP KODU: " + connection.getResponseCode());
			}

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String sonuc = bufferedReader.readLine();
			System.out.println(sonuc);
			connection.disconnect();

			JAXBContext jaxbContext = JAXBContext.newInstance(Musteri.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Musteri musteri = (Musteri) unmarshaller.unmarshal(new StringReader(sonuc));

			System.out.println(musteri.getMusteriId());
			System.out.println(musteri.getMusteriAdiSoyadi());
			System.out.println(musteri.getMusteriBilgi());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}