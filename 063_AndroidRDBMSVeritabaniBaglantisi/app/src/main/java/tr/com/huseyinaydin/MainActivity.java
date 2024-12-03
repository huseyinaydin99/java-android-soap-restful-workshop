package tr.com.huseyinaydin;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.ksoap2.SoapEnvelope;
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

    private final String URL = "http://10.0.2.2:8080/_008_SOAPVeritabaniBaglantisi/services/VeritabaniWS?wsdl";
    private final String NAMESPACE = "http://huseyinaydin.com.tr";
    private final String METHOD_NAME = "personelVerileriniGetir";
    private final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        new SoapRequestTask().execute(); // AsyncTask başlatılır
    }

    private class SoapRequestTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            try {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                androidHttpTransport.call(SOAP_ACTION, envelope);
                Object result = envelope.getResponse();

                SoapPrimitive response = (SoapPrimitive) result;
                String gelenSonuc = response.toString();
                String[] resultArray = gelenSonuc.split("& ");

                StringBuilder kayitlar = new StringBuilder();
                for (String kayit : resultArray) {
                    kayitlar.append(kayit).append("\n\n");
                }
                return kayitlar.toString();
            } catch (IOException | XmlPullParserException e) {
                e.printStackTrace();
                return "Hata: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            textView1.setText(result);
        }
    }
}