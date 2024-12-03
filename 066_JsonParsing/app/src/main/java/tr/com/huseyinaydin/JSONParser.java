package tr.com.huseyinaydin;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android, WebServis, RESTful.
 *
 */

public class JSONParser {

    private static InputStream is = null;
    private static JSONObject jObj = null;
    private String jsonResult = null;

    //YAPILANDIRICI METOT
    public JSONParser() {
    }

    //URL'DEKI JSON'DEN HTTP request ISTEGI YAPIYOR
    public JSONObject getJSONFromUrl(String url) {
        try {
            //VARSAYILAN ISTEMCI
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();

            is = httpEntity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            is.close();
            jsonResult = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Buffer hatası", "Hatalı sonuç : " + e.toString());
        }

        //STRING HALDEKI VERILERI JSON NESNELERINE CEVIRIYOR
        try {
            jObj = new JSONObject(jsonResult);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("Buffer hatası", "Hatalı sonuç : " + e.toString());
        }
        // JSON String GERI DONUS TIPI
        return jObj;
    }
}