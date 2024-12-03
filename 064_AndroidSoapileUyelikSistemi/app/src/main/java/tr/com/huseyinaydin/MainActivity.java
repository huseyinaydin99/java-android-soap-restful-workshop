package tr.com.huseyinaydin;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

    private final String URL = "http://10.0.2.2:8080/_008_SOAPVeritabaniBaglantisi/services/VeritabaniWS?wsdl";
    private final String NAMESPACE = "http://huseyinaydin.com.tr";
    private final String METHOD_NAME = "uyeGirisKontroluYap";
    private final String SOAP_ACTION = NAMESPACE + METHOD_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLUyeGirisBaglantisi = findViewById(R.id.button1);
        btnLUyeGirisBaglantisi.setOnClickListener(v -> new UyeGirisKontrolTask().execute());

        Button btnUyeEkle = findViewById(R.id.button2);
        btnUyeEkle.setOnClickListener(v -> new YeniUyeEkleTask().execute());
    }

    private class UyeGirisKontrolTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            EditText uyeKullaniciAdi = findViewById(R.id.editText1);
            EditText uyeParola = findViewById(R.id.editText2);

            try {
                SoapObject request = new SoapObject(NAMESPACE, "uyeGirisKontroluYap");

                request.addProperty("uyeKullaniciAdiParametre", uyeKullaniciAdi.getText().toString());
                request.addProperty("uyeParolaParametre", uyeParola.getText().toString());

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                androidHttpTransport.call(NAMESPACE + "uyeGirisKontroluYap", envelope);

                SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                return response.toString();

            } catch (IOException | XmlPullParserException e) {
                e.printStackTrace();
                return "Hata: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            TextView tvSonuc = findViewById(R.id.textView1);
            tvSonuc.setText(result);
        }
    }

    private class YeniUyeEkleTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            EditText uyeKullaniciAdi = findViewById(R.id.editText1);
            EditText uyeParola = findViewById(R.id.editText2);

            try {
                SoapObject request = new SoapObject(NAMESPACE, "uyeKayitEkle");

                request.addProperty("uyeKullaniciAdiParametre", uyeKullaniciAdi.getText().toString());
                request.addProperty("uyeParolaParametre", uyeParola.getText().toString());

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                androidHttpTransport.call(NAMESPACE + "uyeKayitEkle", envelope);

                SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                return response.toString();

            } catch (IOException | XmlPullParserException e) {
                e.printStackTrace();
                return "Hata: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            TextView tvSonuc = findViewById(R.id.textView1);
            tvSonuc.setText(result);

            EditText uyeKullaniciAdi = findViewById(R.id.editText1);
            EditText uyeParola = findViewById(R.id.editText2);
            uyeKullaniciAdi.setText("");
            uyeParola.setText("");
        }
    }
}