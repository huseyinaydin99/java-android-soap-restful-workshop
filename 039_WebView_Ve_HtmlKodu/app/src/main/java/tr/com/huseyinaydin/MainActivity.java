package tr.com.huseyinaydin;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.Manifest;
import android.widget.Toast;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {

    private static final int INTERNET_PERMISSION_CODE = 101;

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
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                    != PackageManager.PERMISSION_GRANTED) {
                // İzin isteme
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        INTERNET_PERMISSION_CODE);
            } else {
                // İzin zaten verilmiş, işlemi gerçekleştirebilirim.
                goruntule();
                Toast.makeText(this, "İzin zaten verilmiş, işlemi gerçekleştirebilirim.\n!", Toast.LENGTH_SHORT).show();
            }
        } else {
            // API 23'ten düşük, izin manifest ile zaten verildi.
            goruntule();
        }
    }

    public void goruntule(){
        WebView webSayfasi = findViewById(R.id.webView1);
        webSayfasi.getSettings().setJavaScriptEnabled(true);
        //webSayfasi.loadUrl("https://www.github.com/huseyinaydin99");

        String veri = "<html>        "
                + "<head>"
                + "        <meta charset='utf-8'>"
                + "        <title>ANDROID PROGRAMLAMA</title>"
                + "        </head>"
                + "        <body>"
                + "        <h1>ANDROID</h1>"
                + "        <h2>WEBVIEW</h2>" + "        <p>HTML</p>"
                + "        <table width='100%' border='1'>"
                + "          <tr>"
                + "            <td bgcolor='#FF0000'><strong>1</strong></td>"
                + "            <td align='center' bgcolor='#00FFFF'><h1>2</h1></td>"
                + "            <td bgcolor='#66CCFF'>3</td>"
                + "          </tr>"
                + "          <tr>"
                + "            <td align='right' valign='bottom' bgcolor='#FF00FF'>4</td>"
                + "            <td bgcolor='#33FF00'><h3><em>5</em></h3></td>"
                + "            <td bgcolor='#FFFF00'><h1>6</h1></td>"
                + "          </tr>" + "        </table>"
                + "        </body>" + "        </html>";

        webSayfasi.loadData(veri, "text/html", "UTF-16");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == INTERNET_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // İzin verildi
                goruntule();
            } else {
                // İzin reddedildi, kullanıcıya bilgilendirme yapılabilir.
                Toast.makeText(this, "İnternet izni gerekli!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}