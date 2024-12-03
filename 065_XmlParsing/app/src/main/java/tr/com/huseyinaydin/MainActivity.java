package tr.com.huseyinaydin;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Android, WebServis, RESTful.
 * @since 1994
 */
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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

    // UYGULAMADAKI TUM SABIT DEGERLER
    static final String URL = "http://raw.githubusercontent.com/huseyinaydin99/test11/refs/heads/main/liste.xml";

    // XML node keys KOK ELEMANLARI
    static final String KAYIT = "item";
    static final String ID = "id";
    static final String ADI = "name";
    static final String MAAS = "salary";
    static final String ACIKLAMA = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Execute the AsyncTask to fetch and parse XML data
        new FetchDataTask().execute(URL);
    }

    // AsyncTask to fetch and parse XML in the background
    private class FetchDataTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>> {

        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(String... urls) {
            ArrayList<HashMap<String, String>> menuItems = new ArrayList<>();
            XMLParser parser = new XMLParser();
            String xmlResult = parser.getXmlFromUrl(urls[0]);
            System.out.println("selam ");
            System.out.println(xmlResult);
            System.out.println(urls[0]);
            System.out.println("####### #######");
            Log.d(xmlResult,xmlResult);
            Document doc = parser.getDomElement(xmlResult);

            NodeList nl = doc.getElementsByTagName(KAYIT);

            for (int i = 0; i < nl.getLength(); i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                Element e = (Element) nl.item(i);

                map.put(ID, parser.getValue(e, ID));
                map.put(ADI, parser.getValue(e, ADI));
                map.put(MAAS, parser.getValue(e, MAAS));
                map.put(ACIKLAMA, parser.getValue(e, ACIKLAMA));

                menuItems.add(map);
            }
            return menuItems;
        }

        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> menuItems) {
            // Once the background task is complete, update the UI
            if (menuItems != null && !menuItems.isEmpty()) {
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
                        // Listeye tıklanıldığında verileri alıp yeni ekrana aktar
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
            } else {
                Toast.makeText(MainActivity.this, "Data not found or error occurred", Toast.LENGTH_SHORT).show();
            }
        }
    }
}