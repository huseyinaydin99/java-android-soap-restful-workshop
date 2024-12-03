package tr.com.huseyinaydin;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android, WebServis, SOAP.
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button topla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topla = findViewById(R.id.hesapla);
        topla.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == topla) {
            EditText sayi1 = findViewById(R.id.etSayi1);
            EditText sayi2 = findViewById(R.id.etSayi2);

            String sayi_1 = sayi1.getText().toString();
            String sayi_2 = sayi2.getText().toString();

            new HesaplaAsyncTask().execute(sayi_1, sayi_2);
        }
    }

    private class HesaplaAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String sonuc = null;
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://10.0.2.2/android_baglantisi/hesapla.php");

                List<NameValuePair> nameValuePairList = new ArrayList<>();
                nameValuePairList.add(new BasicNameValuePair("sayi1", params[0]));
                nameValuePairList.add(new BasicNameValuePair("sayi2", params[1]));

                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
                HttpResponse response = httpClient.execute(httpPost);

                sonuc = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sonuc;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView tv = findViewById(R.id.txtSonuc);
            if (result != null) {
                tv.setText(result);
            } else {
                tv.setText("Bir hata oluştu!");
            }
        }
    }
}
