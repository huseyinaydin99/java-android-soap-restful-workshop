package tr.com.huseyinaydin.cilent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.catalina.connector.ClientAbortException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

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

			/*
			URL url = new URL ("http://localhost:8080/_015_RestfulJerseyJSON/rest/market/detay/"+idDegeri+"/jsongetir" );
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json;charset=utf-8");
			
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException(" GELEN HTTP KODU: "+ connection.getResponseCode());
			}
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String sonuc = bufferedReader.readLine();
			System.out.println(sonuc);
			connection.disconnect();
			*/
			
			/*Client client = Client.create();
			WebResource resource = client.resource("http://localhost:8080/_015_RestfulJerseyJSON/rest/market/detay/" + idDegeri + "/jsongetir");
			ClientResponse response = resource.accept("application/json;charset=utf-8").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException(" GELEN HTTP KODU: " + response.getStatus());
			}

			String sonuc = response.getEntity(String.class);
			System.out.println(sonuc);
			client.destroy();

			JAXBContext jaxbContext = JAXBContext.newInstance(Musteri.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Musteri musteri = (Musteri) unmarshaller.unmarshal(new StringReader(sonuc));

			System.out.println(musteri.getMusteriId());
			System.out.println(musteri.getMusteriAdiSoyadi());
			System.out.println(musteri.getMusteriBilgi());*/
			
            Client client = Client.create();
            WebResource resource = client.resource("http://localhost:8080/_015_RestfulJerseyJSON/rest/market/detay/" + idDegeri + "/jsongetir");
            ClientResponse response = resource.accept("application/json;charset=utf-8").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException(" GELEN HTTP KODU: " + response.getStatus());
            }

            String sonuc = response.getEntity(String.class);
            System.out.println("JSON Sonuç: " + sonuc);
            System.out.println("");
            System.out.println("#############################");
            System.out.println("");
            client.destroy();

            // Jackson ile JSON'u nesneye dönüştür
            ObjectMapper objectMapper = new ObjectMapper();
            Musteri musteri = objectMapper.readValue(sonuc, Musteri.class);

            System.out.println(musteri.getMusteriId());
            System.out.println(musteri.getMusteriAdiSoyadi());
            System.out.println(musteri.getMusteriBilgi());
            
            System.out.println("");
            System.out.println("##############################");
            System.out.println("");
            
            Gson gson = new Gson();
            Musteri musteri2 = gson.fromJson(sonuc, Musteri.class);
            
            System.out.println(musteri2.getMusteriId());
            System.out.println(musteri2.getMusteriAdiSoyadi());
            System.out.println(musteri2.getMusteriBilgi());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}