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

import tr.com.huseyinaydin.model.Pojo;
import android.widget.AdapterView.OnItemClickListener;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private ListView listemiz;
    private ListViewCustomAdapter adapter;
    private ArrayList<Object> itemList;
    private Pojo pojo;

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

        listeyiHazirla();
        listemiz = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewCustomAdapter(this, itemList);
        listemiz.setAdapter(adapter);

        listemiz.setOnItemClickListener(this);
    }

    public void listeyiHazirla(){
        itemList = new ArrayList<Object>();

        ListeyeElemanEkle(R.drawable.ic_add, "Ekle", "Ekleme işlemi");
        ListeyeElemanEkle(R.drawable.ic_delete, "Sil", "Silme işlemi");
        ListeyeElemanEkle(R.drawable.ic_down, "Aşağı", "Aşağı al");
        ListeyeElemanEkle(R.drawable.ic_info, "Bilgi", "Bilgi ver");
        ListeyeElemanEkle(R.drawable.ic_help, "Yardım", "Yardım et");
        ListeyeElemanEkle(R.drawable.ic_download, "İndir", "İndirme işlemi");
        ListeyeElemanEkle(R.drawable.ic_mail, "Mail", "Eposta gönder");
        ListeyeElemanEkle(R.drawable.ic_search, "Ara", "Arama yap");
        ListeyeElemanEkle(R.drawable.ic_settings, "Ayarlar", "Ayar yap");
    }


    public void ListeyeElemanEkle(int simge, String yazi, String aciklama){
        pojo = new Pojo();
        pojo.setAciklama(aciklama);
        pojo.setSimge(simge);
        pojo.setYazi(yazi);
        itemList.add(pojo);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("Merhaba");
        Toast.makeText(this, "Eleman: " + itemList.get(position).toString(), Toast.LENGTH_SHORT).show();
    }
}