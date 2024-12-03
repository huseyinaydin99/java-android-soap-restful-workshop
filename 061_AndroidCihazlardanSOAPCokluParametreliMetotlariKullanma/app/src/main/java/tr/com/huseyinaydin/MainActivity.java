package tr.com.huseyinaydin;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

    private final String URL = "http://10.0.2.2:8080/_004_SOAPSunucusu/services/SelamWS?wsdl";
    private final String NAMESPACE = "http://huseyinaydin.com.tr";
    private final String METHOD_ADI1 = "selamVer";
    private final String METHOD_ADI2 = "selamVerIkiParametreli";
    private final String METHOD_ADI3 = "selamVerUcParametreli";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // İlk SOAP isteği AsyncTask ile gönder
        new SoapTask(METHOD_ADI1, "Hüseyin AYDIN", null, null, R.id.textView1).execute();

        // İkinci SOAP isteği AsyncTask ile gönder
        new SoapTask(METHOD_ADI2, "Hüseyin AYDIN", "Java Developer", null, R.id.textView2).execute();

        // Üçüncü SOAP isteği AsyncTask ile gönder
        new SoapTask(METHOD_ADI3, "Hüseyin AYDIN", "Java Developer", null, R.id.textView3).execute();
    }

    private class SoapTask extends AsyncTask<Void, Void, String> {
        private String methodAdi;
        private String adiSoyadi;
        private String unvani;
        private String yasi;
        private int textViewId;

        public SoapTask(String methodAdi, String adiSoyadi, String unvani, String yasi, int textViewId) {
            this.methodAdi = methodAdi;
            this.adiSoyadi = adiSoyadi;
            this.unvani = unvani;
            this.yasi = yasi;
            this.textViewId = textViewId;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                SoapObject request = new SoapObject(NAMESPACE, methodAdi);

                if (adiSoyadi != null) {
                    PropertyInfo adiSoyadiProp = new PropertyInfo();
                    adiSoyadiProp.setName("adiSoyadi");
                    adiSoyadiProp.setValue(adiSoyadi);
                    adiSoyadiProp.setType(String.class);
                    request.addProperty(adiSoyadiProp);
                }

                if (unvani != null) {
                    PropertyInfo unvaniProp = new PropertyInfo();
                    unvaniProp.setName("unvani");
                    unvaniProp.setValue(unvani);
                    unvaniProp.setType(String.class);
                    request.addProperty(unvaniProp);
                }

                if (yasi != null) {
                    PropertyInfo yasiProp = new PropertyInfo();
                    yasiProp.setName("yasi");
                    yasiProp.setValue(yasi);
                    yasiProp.setType(String.class);
                    request.addProperty(yasiProp);
                }

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.setOutputSoapObject(request);

                HttpTransportSE httpTransport = new HttpTransportSE(URL);
                httpTransport.call(NAMESPACE + "/" + methodAdi, envelope);

                SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                return response.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "Hata: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = findViewById(textViewId);
            textView.setText(result);
        }
    }
}