package tr.com.huseyinaydin.services.restful;

//بسم الله الرحمن الرحيم

/**
*
* @author Huseyin_Aydin
* @since 1994
* @category Java, Android, WebServis, RESTful.
*
*/

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tr.com.huseyinaydin.Musteri;

//بسم الله الرحمن الرحيم

/**
*
* @author Huseyin_Aydin
* @since 1994
* @category Java, Android, WebServis, RESTful.
*
*/

//http://localhost:8080/_015_RestfulJerseyJSON/rest/market
@Path(value = "/market")
public class MusteriRestfulService {

	//http://localhost:8080/_015_RestfulJerseyJSON/rest/market/detay/{id}/xmlgetir
	@GET
	@Path(value = "/detay/{id}/xmlgetir")
	//@Produces (MediaType.APPLICATION_JSON+";charset=utf-8")
	@Produces("application/xml;charset=utf-8")
	public Musteri getMusteriDetayAlXml(@PathParam("id") int id) {
		Musteri musteri = new Musteri();
		musteri.setMusteriId(id);
		musteri.setMusteriAdiSoyadi("Hüseyin AYDIN");
		musteri.setMusteriBilgi("Java Developer");

		return musteri;
	}

	//http://localhost:8080/_015_RestfulJerseyJSON/rest/market/detay/{id}/jsongetir
	@GET
	@Path(value = "/detay/{id}/jsongetir")
	//@Produces (MediaType.APPLICATION_JSON+";charset=utf-8")
	@Produces("application/json;charset=utf-8")
	public Musteri getMusteriDetayAlJson(@PathParam("id") int id) {
		Musteri musteri = new Musteri();
		musteri.setMusteriId(id);
		musteri.setMusteriAdiSoyadi("Hüseyin AYDIN");
		musteri.setMusteriBilgi("Java Developer");

		return musteri;
	}
}