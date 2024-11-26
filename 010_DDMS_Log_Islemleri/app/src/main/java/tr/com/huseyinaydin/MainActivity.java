package tr.com.huseyinaydin;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG_ISLEMLERI";

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

        try {
            Log.d("DENEME", String.format("x0 = %5.2f, x1 = %5.2.f", "BİRİNCİ MESAJ", "İKİNCİ mesaj"));
        } catch (Exception e) {
            Log.e(TAG, "HATA: errors");
            Log.w(TAG, "UYARI: warnings");
            Log.i(TAG, "BİLGİLENDİRME: informational");
            Log.d(TAG, "HATA AYIKLAMA: debug");
            Log.v(TAG, "AYRINTTLI MESAJ: verbose");
            Log.wtf(TAG, "FECİ BİR HATA: What a Teribble Failure");

            Log.d("Deneme", "Uygulamanın seyir(loglama) defteri için bir hata ayıklama mesajı");
        }
    }
}