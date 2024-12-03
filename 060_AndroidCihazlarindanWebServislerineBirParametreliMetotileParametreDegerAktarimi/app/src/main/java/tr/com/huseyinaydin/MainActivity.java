package tr.com.huseyinaydin;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android, WebServis, SOAP.
 *
 */

public class MainActivity extends AppCompatActivity {

    private final String URL = "http://10.0.2.2:8080/_002_SelamWebServisKardes/services/SelamWS?wsdl";
    private final String NAMESPACE = "http://huseyinaydin.com.tr";
    private final String METHOD_ADI1 = "selamVer";
    private final String SOAP_OLAYI1 = NAMESPACE + "/" + METHOD_ADI1;
    private final String METHOD_ADI2 = "selamVerIkiParametreli";
    private final String SOAP_OLAYI2 = NAMESPACE + "/" + METHOD_ADI2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // İlk Web Servis çağrısını başlat
        new WebServiceTask().execute(METHOD_ADI1, "Hüseyin AYDIN", null);

        // İkinci Web Servis çağrısını başlat
        new WebServiceTask().execute(METHOD_ADI2, "Hüseyin AYDIN", "Java Developer");
    }

    private class WebServiceTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String methodAdi = params[0];
            String adiSoyadi = params[1];
            String unvani = params.length > 2 ? params[2] : null;

            SoapObject request_istek = new SoapObject(NAMESPACE, methodAdi);

            // adiSoyadi parametresini ekle
            PropertyInfo adiSoyadiOzellikBilgisi = new PropertyInfo();
            adiSoyadiOzellikBilgisi.setName("adiSoyadi");
            adiSoyadiOzellikBilgisi.setType(String.class);
            adiSoyadiOzellikBilgisi.setValue(adiSoyadi);
            request_istek.addProperty(adiSoyadiOzellikBilgisi);

            // Eğer METHOD_ADI2 ise unvani parametresini ekle
            if (METHOD_ADI2.equals(methodAdi) && unvani != null) {
                PropertyInfo unvaniOzellikBilgisi = new PropertyInfo();
                unvaniOzellikBilgisi.setName("unvani");
                unvaniOzellikBilgisi.setType(String.class);
                unvaniOzellikBilgisi.setValue(unvani);
                request_istek.addProperty(unvaniOzellikBilgisi);
            }

            SoapSerializationEnvelope zarf = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            zarf.setOutputSoapObject(request_istek);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

            try {
                String soapOlayi = NAMESPACE + "/" + methodAdi;
                androidHttpTransport.call(soapOlayi, zarf);
                SoapPrimitive response_gelenCevap = (SoapPrimitive) zarf.getResponse();
                return response_gelenCevap.toString();
            } catch (IOException | XmlPullParserException e) {
                e.printStackTrace();
                return "HATA: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            // Sonuçları ekrana yazdır
            if (result.contains("selamVer")) {
                TextView textView1 = findViewById(R.id.textView);
                textView1.setText(result);
            } else {
                TextView textView2 = findViewById(R.id.textView2);
                textView2.setText(result);
            }
        }
    }
}