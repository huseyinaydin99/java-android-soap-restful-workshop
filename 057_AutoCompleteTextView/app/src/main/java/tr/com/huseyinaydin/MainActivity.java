package tr.com.huseyinaydin;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

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

    private AutoCompleteTextView autocompletetextview;

    String[] array = {
            "Hüseyin AYDIN",
            "Ayşe Ayşe",
            "Kerem Ünlü",
            "Samet Ünlü",
            "Ali Ünlü",
            "Birsel Ünlü",
            "Semih Ünlü",
            "Ender Yıldırım",
            "Ayturan Yıldırım",
            "Gönül Gönül",
            "Ayhan Ayhan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        autocompletetextview = findViewById(R.id.autocompletetextview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, array);
        autocompletetextview.setThreshold(2);
        autocompletetextview.setAdapter(adapter);
    }
}