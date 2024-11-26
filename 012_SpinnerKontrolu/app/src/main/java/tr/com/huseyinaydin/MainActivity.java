package tr.com.huseyinaydin;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Android
 * @since 1994
 */

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;

    private static final String[] personel = {
            "Hüseyin AYDIN", "Ceyda Koç",
            "Personel Personel", "Rei Ko", "Admin Admin", "Kai Hiwatari",
            "Çorumlu Şakir2", "Küfürbaz Haydo", "Speedy(Zibidi) Gonzales", "Buğra Dost",
            "Sülüman Gandalf", "Kinomia Takao"};

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

        acilirListeyiGoster();
    }

    public void acilirListeyiGoster() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(this,
                android.R.layout.simple_list_item_checked, personel);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new bizimSpinnerListener());
    }

    class bizimSpinnerListener implements Spinner.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            Toast.makeText(parent.getContext(), "ADI SOYADI: " + parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            Toast.makeText(getApplicationContext(), "PERSONEL SEÇİLMEDİ", Toast.LENGTH_SHORT);
        }
    }
}