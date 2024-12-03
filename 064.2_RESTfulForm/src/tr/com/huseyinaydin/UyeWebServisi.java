package tr.com.huseyinaydin;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//بسم الله الرحمن الرحيم

/**
*
* @author Huseyin_Aydin
* @since 1994
* @category Java, Android, WebServis, RESTful.
*
*/

@Path(value = "/uye")
public class UyeWebServisi {

	//http://localhost:8080/_013_RESTfulForm/rest/uye/ekle		
	@POST
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	@Path(value = "/ekle")
	public Response uyeEkle(@FormParam("kullaniciAdi") String adi, @FormParam("parolasi") String sifre) {
		String sonuc = "<hr>KAYDINIZ YAPILDI. BİLGİ: " + adi + "    ve   " + sifre;
		return Response.status(200).entity(sonuc).build();
	}

	//http://localhost:8080/_013_RESTfulForm/rest/uye/giris		
	@POST
	@Produces("text/html;charset=utf-8")
	@Path(value = "/giris")
	public Response uyeGirisYap(@FormParam("kullaniciAdi") String adi, @FormParam("parolasi") String sifre) {
		String sonuc = "<hr>BİLGİ: " + adi + "    ve   " + sifre;
		return Response.status(200).entity(sonuc).build();
	}
}