package tr.com.huseyinaydin;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

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

    private Chronometer chronometer;
    private Button button;

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

        chronometer = findViewById(R.id.chronometer1);

        button = findViewById(R.id.start);
        button.setOnClickListener(mStartListener);

        button = findViewById(R.id.stop);
        button.setOnClickListener(mStopListener);

        button = findViewById(R.id.reset);
        button.setOnClickListener(mResetListener);

        button = findViewById(R.id.set_format);
        button.setOnClickListener(mSetFormatListener);

        button = findViewById(R.id.clear_format);
        button.setOnClickListener(mClearFormatListener);
    }

    View.OnClickListener mStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            chronometer.start();
        }
    };

    View.OnClickListener mStopListener = new View.OnClickListener() {
        public void onClick(View v) {
            chronometer.stop();
        }
    };

    View.OnClickListener mResetListener = new View.OnClickListener() {
        public void onClick(View v) {
            //Bu kod, bir Chronometer bileşeninin başlangıç zamanını, cihazın çalışma süresini milisaniye cinsinden döndüren SystemClock.elapsedRealtime() değeriyle sıfırlayarak ayarlar.
            chronometer.setBase(SystemClock.elapsedRealtime());
        }
    };

    View.OnClickListener mSetFormatListener = new View.OnClickListener() {
        public void onClick(View v) {
            chronometer.setFormat("Formatlı zaman (%s)");
        }
    };

    View.OnClickListener mClearFormatListener = new View.OnClickListener() {
        public void onClick(View v) {
            chronometer.setFormat(null);
        }
    };
}