package tr.com.huseyinaydin;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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

    //1. HATA AYIKLAMA
    private final static String DEBUG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.country_root), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //2. HARITAYA TIKLAYINCA AC
        ImageView map = findViewById(R.id.ImageViewMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String localeString = getResources().getString(R.string.locale);
                Log.d(DEBUG_TAG, "Verilen mesaj: " + localeString + " alınamadı.");

                Context context = getApplicationContext();
                CharSequence text = localeString;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                //3.Toast mesajının posisyonu
                toast.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
                toast.show();
            }
        });
    }
}