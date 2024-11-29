package tr.com.huseyinaydin;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */


public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button btnOku;
    private EditText txtKonusmaMetni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tts = new TextToSpeech(this, this);
        btnOku = findViewById(R.id.btnOku);
        txtKonusmaMetni = findViewById(R.id.txtKonusmaMetni);

        btnOku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                speakOut();
            }
        });
    }

    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        System.out.println("on init");
        if (status == TextToSpeech.SUCCESS) {
            System.out.println("SUCCESS");
            int result = tts.setLanguage(Locale.getDefault());
            // tts.setPitch(5); // Saha düzeyini ayarlama
            // tts.setSpeechRate(2); // konuşma hızını ayarlama
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Dil desteklenmiyor.");
                System.out.println("Dil desteklenmiyor.");
            }
            else {
                System.out.println("Dil destekleniyor.");
                btnOku.setEnabled(true);
                speakOut();
            }
        } else {
            Log.e("TTS", "Başlatma başarısız.");
        }
    }

    private void speakOut() {
        String text = txtKonusmaMetni.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}