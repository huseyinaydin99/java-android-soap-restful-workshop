package tr.com.huseyinaydin;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

import static tr.com.huseyinaydin.SabitDegerlerSinifi.BIRINCI_KOLON;
import static tr.com.huseyinaydin.SabitDegerlerSinifi.DORDUNCU_KOLON;
import static tr.com.huseyinaydin.SabitDegerlerSinifi.IKINCI_KOLON;
import static tr.com.huseyinaydin.SabitDegerlerSinifi.UCUNCU_KOLON;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, String>> list;

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

        ListView listView = findViewById(R.id.listView1);
        kitapYazarListesi();
        ListViewAdapter adapter = new ListViewAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private void kitapYazarListesi() {
        list = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> temp0 = new HashMap<String, String>();
        temp0.put(BIRINCI_KOLON, "Hüseyin AYDIN");
        temp0.put(IKINCI_KOLON, "huseyinaydin99@gmail.com");
        temp0.put(UCUNCU_KOLON, "1994");
        temp0.put(DORDUNCU_KOLON, "30");
        list.add(temp0);

        HashMap<String, String> temp1 = new HashMap<String, String>();
        temp1.put(BIRINCI_KOLON, "Yasin AYDIN");
        temp1.put(IKINCI_KOLON, "e-posta1@gmail.com");
        temp1.put(UCUNCU_KOLON, "2000");
        temp1.put(DORDUNCU_KOLON, "25");
        list.add(temp1);

        HashMap<String, String> temp2 = new HashMap<String, String>();
        temp2.put(BIRINCI_KOLON, "Ömer Faruk");
        temp2.put(IKINCI_KOLON, "e-posta2@gmail.com");
        temp2.put(UCUNCU_KOLON, "2011");
        temp2.put(DORDUNCU_KOLON, "13");
        list.add(temp2);

        HashMap<String, String> temp3 = new HashMap<String, String>();
        temp3.put(BIRINCI_KOLON, "Rumissa Rumissa");
        temp3.put(IKINCI_KOLON, "e-posta3@gmail.com");
        temp3.put(UCUNCU_KOLON, "1999");
        temp3.put(DORDUNCU_KOLON, "26");
        list.add(temp3);

        HashMap<String, String> temp4 = new HashMap<String, String>();
        temp4.put(BIRINCI_KOLON, "Ceyda Ceyda");
        temp4.put(IKINCI_KOLON, "e-posta4@gmail.com");
        temp4.put(UCUNCU_KOLON, "1994");
        temp4.put(DORDUNCU_KOLON, "30");
        list.add(temp4);

        HashMap<String, String> temp5 = new HashMap<String, String>();
        temp5.put(BIRINCI_KOLON, "Hüseyin AYDIN");
        temp5.put(IKINCI_KOLON, "e-posta5@gmail.com");
        temp5.put(UCUNCU_KOLON, "1942");
        temp5.put(DORDUNCU_KOLON, "80");
        list.add(temp5);

        HashMap<String, String> temp6 = new HashMap<String, String>();
        temp6.put(BIRINCI_KOLON, "Gonul Gonul");
        temp6.put(IKINCI_KOLON, "e-posta6@gmail.com");
        temp6.put(UCUNCU_KOLON, "1975");
        temp6.put(DORDUNCU_KOLON, "40");
        list.add(temp6);
    }
}