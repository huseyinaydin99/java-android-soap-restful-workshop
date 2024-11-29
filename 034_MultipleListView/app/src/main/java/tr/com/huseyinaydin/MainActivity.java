package tr.com.huseyinaydin;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        ArrayList<KayitBilgileri> kayitBilgileri = AramaListesiniAl();

        final ListView listView = findViewById(R.id.ogrenci_listesi);
        listView.setAdapter(new BizimAdapterSinifimiz(this, kayitBilgileri));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                KayitBilgileri kayit = (KayitBilgileri) o;
                Toast.makeText(MainActivity.this, "Seçilen kayıt\n" + kayit.getAdiSoyadi()
                                + "\n" + kayit.getSehir()
                                + "\n" + kayit.getTelefon(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<KayitBilgileri> AramaListesiniAl() {
        ArrayList<KayitBilgileri> sonuc = new ArrayList<KayitBilgileri>();

        KayitBilgileri kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Hüseyin AYDIN");
        kayit.setSehir("Niğde");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Soğan Özdoğan");
        kayit.setSehir("Aktaş KaşabaşiĞ");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Murat Yavuz");
        kayit.setSehir("Çiftehan");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Samet ÜNLÜ");
        kayit.setSehir("Derinkuyu/Misli");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Ali Kemal Alpaçino");
        kayit.setSehir("Semendere");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Mehmet Arabaci");
        kayit.setSehir("Mırtanlılı");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Şakir İki");
        kayit.setSehir("Çorum Osmancık Belediye Spor");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Önder Yıldırım");
        kayit.setSehir("Melendiz Mel Eder");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Ender Yıldırım");
        kayit.setSehir("Niğde/Melendiz Mel Eder");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        kayit = new KayitBilgileri();
        kayit.setAdiSoyadi("Şakire Üç");
        kayit.setSehir("Çorum Spor");
        kayit.setTelefon("0555 555 55 55");
        sonuc.add(kayit);

        return sonuc;
    }
}