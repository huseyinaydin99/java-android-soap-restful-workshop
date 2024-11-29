package tr.com.huseyinaydin;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.Manifest;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {

    private Button btnShowProgress;
    private ProgressDialog pDialog;
    private ImageView imgIndirilen;

    // Yatay ilerleme çubuğu
    public static final int progress_bar_type = 0;
    private static String file_url = "https://m.media-amazon.com/images/I/81wQIyojm1L._AC_UF1000,1000_QL80_.jpg";
    private DownloadFileFromURL downloadFileFromURL;
    private static final int STORAGE_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // İzni kontrol et
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                // İzin isteme
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        STORAGE_PERMISSION_CODE);
            } else {
                // İzin zaten verilmiş, işlemi gerçekleştirebilirsiniz
                writeToFile();
            }
        } else {
            // API 23'ten düşük, izin manifest ile zaten verilmiştir
            writeToFile();
        }

    }

    public void writeToFile(){
        btnShowProgress = findViewById(R.id.btnProgressBar);
        imgIndirilen = findViewById(R.id.imgIndirilen);

        downloadFileFromURL = new DownloadFileFromURL();

        btnShowProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // başlıyor new Async Task
                new DownloadFileFromURL().execute(file_url);
            }
        });
    }

    /*
     Dialog Göster
    */
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type:
                pDialog = new ProgressDialog(this);
                pDialog.setMessage("İndiriliyor...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }

    /*
     Geri planda Async Task ile indirilen dosya
     */
    class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /*
        Geri planda thread'den önce ki durum
        Progress Bar Dialog gösteriliyor
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        /*
         İndirme işlemi thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();
                // Dosya uzunluğu
                int lenghtOfFile = conection.getContentLength();
                // input stream ile 8k buffer olarak dosya okunuyor.
                InputStream input = new BufferedInputStream(url.openStream(), 106496);
                // Output stream ile indirilen dosya yazılıyor.
                OutputStream output = new FileOutputStream("/sdcard/downloadedfile.jpg");
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    // progress işlemi kendini tazeliyor.
                    publishProgress(""+(int)((total*100)/lenghtOfFile));
                    // bilgi yazılıyor
                    output.write(data, 0, count);
                }
                // son durum tazeleniyor
                output.flush();
                // aktarım streams sonuçlanında kapanışlar yapılıyor
                output.close();
                input.close();
            } catch (Exception e) {
                Log.e("Hata: ", e.getMessage());
            }
            return null;
        }

        /*
         progress bar yenileniyor.
        */
        protected void onProgressUpdate(String... progress) {
            // yüzde olarak değer
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /*
         Tamamlanmadan sonra ki durumda progress dialog sonlanıyor
         */
        @Override
        protected void onPostExecute(String file_url) {
            // İndirme bitince progress dialog yok ediliyor.
            dismissDialog(progress_bar_type);
            // sdcard'a indilen resim okunuyor ve gösteriliyor
            String imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg";
            // İnen resmin gösterilişi
            imgIndirilen.setImageDrawable(Drawable.createFromPath(imagePath));
        }
    }
}