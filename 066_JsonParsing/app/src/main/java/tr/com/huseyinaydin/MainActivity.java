package tr.com.huseyinaydin;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ListView;
import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android, WebServis, RESTful.
 *
 */

public class MainActivity extends ListActivity {

    private static final String URL = "http://raw.githubusercontent.com/huseyinaydin99/test11/refs/heads/main/listt.json";
    private static final String KAYIT = "item";
    private static final String ID = "id";
    private static final String ADI = "name";
    private static final String MAAS = "salary";
    private static final String ACIKLAMA = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asenkron görev başlatılıyor
        new LoadDataTask().execute();
    }

    // Asynctask sınıfı
    private class LoadDataTask extends AsyncTask<Void, Void, ArrayList<HashMap<String, String>>> {

        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(Void... voids) {
            ArrayList<HashMap<String, String>> menuItems = new ArrayList<>();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = parser.getJSONFromUrl(URL);
            JSONArray jsonArray = null;

            try {
                // JSON verisi alınıyor
                jsonArray = jsonObject.getJSONArray(KAYIT);

                // JSON dizisindeki elemanlar döngü ile alınıyor
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject kayit = jsonArray.getJSONObject(i);

                    String id = kayit.getString(ID);
                    String adi = kayit.getString(ADI);
                    String maas = kayit.getString(MAAS);
                    String aciklama = kayit.getString(ACIKLAMA);

                    HashMap<String, String> map = new HashMap<>();
                    map.put(ID, id);
                    map.put(ADI, adi);
                    map.put(MAAS, maas);
                    map.put(ACIKLAMA, aciklama);

                    menuItems.add(map);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return menuItems;
        }

        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> menuItems) {
            // UI'yi güncelleme işlemi
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this,
                    menuItems,
                    R.layout.list_item,
                    new String[]{ADI, ACIKLAMA, MAAS},
                    new int[]{R.id.adi, R.id.aciklama, R.id.maas}
            );
            setListAdapter(adapter);

            ListView lv = getListView();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Liste elemanına tıklandığında veri gönderme
                    String adi = ((TextView) view.findViewById(R.id.adi)).getText().toString();
                    String maas = ((TextView) view.findViewById(R.id.maas)).getText().toString();
                    String aciklama = ((TextView) view.findViewById(R.id.aciklama)).getText().toString();

                    Intent in = new Intent(getApplicationContext(), SingleItemActivity.class);
                    in.putExtra(ADI, adi);
                    in.putExtra(MAAS, maas);
                    in.putExtra(ACIKLAMA, aciklama);
                    startActivity(in);
                }
            });
        }
    }
}