package tr.com.huseyinaydin;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private EditText et;
    private String personel[] = {
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

    private ArrayList<String> diziListesi = new ArrayList<String>();
    private int kelimeUzunlugu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        lv = findViewById(R.id.lvSonuc);
        et = findViewById(R.id.etAranacakSey);

        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personel));

        et.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                kelimeUzunlugu = et.getText().length();
                diziListesi.clear();
                for (int i = 0; i < personel.length; i++) {
                    if (kelimeUzunlugu <= personel[i].length()) {
                        if (et.getText().toString().equalsIgnoreCase((String) personel[i].subSequence(0, kelimeUzunlugu))) {
                            diziListesi.add(personel[i]);
                        }
                    }
                }
                lv.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, diziListesi));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
    }
}