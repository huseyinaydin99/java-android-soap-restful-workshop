package tr.com.huseyinaydin;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {

    private ExpandableListAdapter expandableListAdapter ;
    private ExpandableListView expandableListView;
    private List<String> listeVeriBaslik;
    private HashMap<String, List<String>> listeVeriCocuk;

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

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView1);
        listeVerileriniHazirla();

        expandableListAdapter = new ExpandableListAdapter(this, listeVeriBaslik, listeVeriCocuk);
        expandableListView.setAdapter(expandableListAdapter);

        // Listview grubunun tiklanmasini dinleyen metot
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Grup Tıklandı " + listeVeriBaslik.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Grup acilmasini dinleyen metot
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), listeVeriBaslik.get(groupPosition) + " Açıldı", Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Grup kapanmasini dinleyen metot
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), listeVeriBaslik.get(groupPosition) + " Toplandı", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), listeVeriBaslik.get(groupPosition) + " : " + listeVeriCocuk.get(listeVeriBaslik.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void listeVerileriniHazirla() {
        listeVeriBaslik = new ArrayList<String>();
        listeVeriCocuk = new HashMap<String, List<String>>();

        // Baslik kisimlari
        listeVeriBaslik.add("Kuruluş   (1299–1453)");
        listeVeriBaslik.add("Yükselme  (1453–1683)");
        listeVeriBaslik.add("Duraklama (1683–1827)");
        listeVeriBaslik.add("Gerileme  (1828–1908)");
        listeVeriBaslik.add("Dağılma   (1908–1922)");

        // Basliklara girilen veriler
        List<String> kurulusDonemi = new ArrayList<String>();
        kurulusDonemi.add("Osman Gazi (1299 - 1326)");
        kurulusDonemi.add("Orhan Gazi (1326 - 1362)");
        kurulusDonemi.add("I. Murad Hüdâvendigâr (1362 - 1389)");
        kurulusDonemi.add("Yıldırım Beyazıt (1389 -1402)");
        kurulusDonemi.add("Fetret Dönemi (1402 - 1413)");
        kurulusDonemi.add("Çelebi Mehmet (1413 -1421)");
        kurulusDonemi.add("II. Murat (1421 - 1451)");

        List<String> yukselmeDonemi = new ArrayList<String>();
        yukselmeDonemi.add("Fatih Sultan Mehmet (1451 – 1481)");
        yukselmeDonemi.add("II. Beyazıt (1481 – 1512)");
        yukselmeDonemi.add("Yavuz Sultan Selim (1512 – 1520)");
        yukselmeDonemi.add("Kanuni Sultan Süleyman (1520 – 1566)");
        yukselmeDonemi.add("II. Selim (1566 – 1574) Sokullu Mehmet Pasa Dönemi");
        yukselmeDonemi.add("III. Murat (1574 – 1595) Sokullu Mehmet Pasa Dönemi");

        List<String> duraklamaDonemi = new ArrayList<String>();
        duraklamaDonemi.add("III.Murat (1574-1595)");
        duraklamaDonemi.add("III.Mehmet (1595-1603)");
        duraklamaDonemi.add("I.Ahmet (1603-1617)");
        duraklamaDonemi.add("II.Osman(Genç)(1618-1622)");
        duraklamaDonemi.add("IV.Murat (1623-1640)");
        duraklamaDonemi.add("IV.Mehmet (1648)-1687)");
        duraklamaDonemi.add("II.Ahmet (1691-1695)");
        duraklamaDonemi.add("III.Mehmet (1595-1603)");
        duraklamaDonemi.add("I.Mustafa (1617-1618)");
        duraklamaDonemi.add("I.Mustafa (1622-1623)");
        duraklamaDonemi.add("I.İbrahim (1640-1648)");
        duraklamaDonemi.add("II.Süleyman(1687-1691)");
        duraklamaDonemi.add("II.Mustafa (1695-1703)");

        List<String> gerilemeDonemi = new ArrayList<>();
        gerilemeDonemi.add("II.Mustafa (1695-1703)");
        gerilemeDonemi.add("III.Ahmet (1703-1730)");
        gerilemeDonemi.add("I.Mahmut (1730-1754)");
        gerilemeDonemi.add("III.Osman (1754-1757)");
        gerilemeDonemi.add("III.Mustafa (1757-1774)");
        gerilemeDonemi.add("I.Abdülhamit (1774-1789)");
        gerilemeDonemi.add("III.Selim (1789-1807)");

        List<String> dagilmaDonemi = new ArrayList<String>();
        dagilmaDonemi.add("IV.Mustafa (1807-1808)");
        dagilmaDonemi.add("II.Mahmut (1808-1839)");
        dagilmaDonemi.add("Abdülmecit (1839-1861)");
        dagilmaDonemi.add("Abdülaziz (1861-1876)");
        dagilmaDonemi.add("V.Murat (1876-1876)");
        dagilmaDonemi.add("II.Abdülhamit Han (1876-1909)");
        dagilmaDonemi.add("V.Mehmet Reşat (1909-1918)");
        dagilmaDonemi.add("Mehmet Vahdettin (1918-1922)");

        listeVeriCocuk.put(listeVeriBaslik.get(0), kurulusDonemi); // Baslik, Cocuk veriler
        listeVeriCocuk.put(listeVeriBaslik.get(1), yukselmeDonemi);
        listeVeriCocuk.put(listeVeriBaslik.get(2), duraklamaDonemi);
        listeVeriCocuk.put(listeVeriBaslik.get(3), gerilemeDonemi);
        listeVeriCocuk.put(listeVeriBaslik.get(4), dagilmaDonemi);
    }
}