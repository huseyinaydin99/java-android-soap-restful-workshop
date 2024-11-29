package tr.com.huseyinaydin;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //private static final String TAG = "_038_IntervalZamanlayici";
    private GeriSayimSinifi geriSayim;
    private long gecenSure;
    private boolean zamanlayiciBasladi = false;
    private Button baslatmaDugmesi;
    private TextView sonDurum;
    private TextView gecenSureyiGoruntule;

    private final long baslamaZamani = 50000;
    private final long intervalAraligi = 1000;

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

        baslatmaDugmesi = this.findViewById(R.id.button);
        baslatmaDugmesi.setOnClickListener(this);

        sonDurum = this.findViewById(R.id.zaman);
        gecenSureyiGoruntule = this.findViewById(R.id.gecenSure);
        geriSayim = new GeriSayimSinifi(baslamaZamani, intervalAraligi);
        sonDurum.setText(sonDurum.getText() + String.valueOf(baslamaZamani));
    }

    @Override
    public void onClick(View v) {
        if (!zamanlayiciBasladi) {
            geriSayim.start();
            zamanlayiciBasladi = true;
            baslatmaDugmesi.setText("Başlat");
        }
        else {
            geriSayim.cancel();
            zamanlayiciBasladi = false;
            baslatmaDugmesi.setText("Sıfırla");
        }
    }

    public class GeriSayimSinifi extends CountDownTimer {
        public GeriSayimSinifi(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            sonDurum.setText("Süre doldu!");
            gecenSureyiGoruntule.setText("Geçen süre: " + String.valueOf(baslamaZamani));
        }

        @Override
        public void onTick(long millisUntilFinished) {
            sonDurum.setText("Kalan süre: " + millisUntilFinished);
            gecenSure = baslamaZamani - millisUntilFinished;
            gecenSureyiGoruntule.setText("Geçen süre: " + String.valueOf(gecenSure));
        }
    }
}