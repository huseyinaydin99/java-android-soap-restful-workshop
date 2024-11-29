package tr.com.huseyinaydin;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Android
 * @since 1994
 */

public class MainActivity extends ListActivity {

    private static final String URL = "http://falanfelanintermilan.org.tr/listeleme.json";

    private static final String KAYIT = "item";
    private static final String ID = "id";
    private static final String ADI = "name";
    private static final String MAAS = "salary";
    private static final String ACIKLAMA = "description";

    private ArrayList<HashMap<String, String>> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuItems = new ArrayList<HashMap<String, String>>();
        new DownloadMenuItemsTask().execute(URL);
    }

    private class DownloadMenuItemsTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>> {
        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(String... urls) {
            String url = urls[0];
            ArrayList<HashMap<String, String>> downloadedMenuItems = new ArrayList<>();

            try {
                JSONParser jParser = new JSONParser();
                JSONObject json = jParser.getJSONFromUrl(url);

                JSONArray item = json.getJSONArray(KAYIT);

                for (int i = 0; i < item.length(); i++) {
                    JSONObject c = item.getJSONObject(i);

                    String id = c.getString(ID);
                    String adi = c.getString(ADI);
                    String maas = c.getString(MAAS) + " ₺";
                    String aciklama = c.getString(ACIKLAMA);

                    HashMap<String, String> map = new HashMap<String, String>();

                    map.put(ID, id);
                    map.put(ADI, adi);
                    map.put(MAAS, maas);
                    map.put(ACIKLAMA, aciklama);

                    downloadedMenuItems.add(map);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return downloadedMenuItems;
        }

        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> downloadedMenuItems) {
            super.onPostExecute(downloadedMenuItems);
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, downloadedMenuItems,
                    R.layout.list_item,
                    new String[]{ADI, ACIKLAMA, MAAS},
                    new int[]{R.id.adi, R.id.aciklama, R.id.maas}
            );
            setListAdapter(adapter);
        }
    }
}