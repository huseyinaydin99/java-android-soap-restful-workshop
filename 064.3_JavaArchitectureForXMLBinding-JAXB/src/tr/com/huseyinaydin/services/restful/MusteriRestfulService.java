package tr.com.huseyinaydin.services.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tr.com.huseyinaydin.Musteri;

// http://localhost:8085/A014_JavaArchitectureForXMLBinding-JAXB/rest/market

//بسم الله الرحمن الرحيم

/**
*
* @author Huseyin_Aydin
* @since 1994
* @category Java, Android, WebServis, RESTful.
*
*/

@Path(value = "/market")
public class MusteriRestfulService {

	// http://localhost:8080/_014_JavaArchitectureForXMLBinding-JAXB/rest/market/detay/{id}
	@GET
	@Path(value = "/detay/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Musteri getMusteriDetayAl(@PathParam("id") int id) {
		Musteri musteri = new Musteri();
		musteri.setMusteriId(id);
		musteri.setMusteriAdiSoyadi("Hüseyin AYDIN");
		musteri.setMusteriBilgi("Java Developer");

		return musteri;
	}
}