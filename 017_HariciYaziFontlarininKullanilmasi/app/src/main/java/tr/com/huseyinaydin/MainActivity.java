package tr.com.huseyinaydin;

import android.graphics.Typeface;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

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

        TextView txt = (TextView) findViewById(R.id.custom_font);
        Typeface font = Typeface.createFromAsset(getAssets(), "Chantelli_Antiqua.ttf");
        txt.setTypeface(font);

        TextView tv = (TextView) findViewById(R.id.tvYazi1);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/CHOCD.otf");
        tv.setTypeface(typeface);

        tv = (TextView) findViewById(R.id.tvYazi2);
        typeface = Typeface.createFromAsset(getAssets(),"fonts/ABADDON.TTF");
        tv.setTypeface(typeface);

        tv = (TextView) findViewById(R.id.tvYazi3);
        typeface = Typeface.createFromAsset(getAssets(),"fonts/ANGEL.otf");
        tv.setTypeface(typeface);

        tv = (TextView) findViewById(R.id.tvYazi4);
        typeface = Typeface.createFromAsset(getAssets(),"fonts/NorthernTerritories.ttf");
        tv.setTypeface(typeface);

        tv = (TextView) findViewById(R.id.tvYazi5);
        typeface = Typeface.createFromAsset(getAssets(),"fonts/WoodWud.ttf");
        tv.setTypeface(typeface);
    }
}