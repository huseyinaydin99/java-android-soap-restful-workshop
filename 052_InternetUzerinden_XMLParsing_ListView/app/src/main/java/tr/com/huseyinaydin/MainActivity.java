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
 * @category Java, Android
 *
 */

public class MainActivity extends ListActivity {

    static final String URL = "http://raw.githubusercontent.com/huseyinaydin99/test11/refs/heads/main/liste.xml";

    static final String KAYIT = "item";
    static final String ID = "id";
    static final String ADI = "name";
    static final String MAAS = "salary";
    static final String ACIKLAMA = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*ArrayList<HashMap<String, String>> menuItems = new ArrayList<>();

        XMLParser parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL);
        Document doc = parser.getDomElement(xml);
        NodeList nl = doc.getElementsByTagName(KAYIT);
        for (int i = 0; i < nl.getLength(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            map.put(ID, parser.getValue(e, ID));
            map.put(ADI, parser.getValue(e, ADI));
            map.put(MAAS, parser.getValue(e, MAAS) + " ₺");
            map.put(ACIKLAMA, parser.getValue(e, ACIKLAMA));

            menuItems.add(map);
        }

        ListAdapter adapter = new SimpleAdapter(
                this, menuItems,
                R.layout.list_item,
                new String[] { ADI, ACIKLAMA, MAAS },
                new int[] { R.id.adi, R.id.aciklama, R.id.maas }
        );

        setListAdapter(adapter);

        ListView lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String adi = ((TextView) view.findViewById(R.id.adi)).getText().toString();
                String maas = ((TextView) view.findViewById(R.id.maas)).getText().toString();
                String aciklama = ((TextView) view.findViewById(R.id.aciklama)).getText().toString();

                Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
                in.putExtra(ADI, adi);
                in.putExtra(MAAS, maas);
                in.putExtra(ACIKLAMA, aciklama);
                startActivity(in);
            }
        });*/

        new DownloadDataTask().execute(URL);
    }

    private class DownloadDataTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>> {

        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(String... urls) {
            String url = urls[0];
            System.out.println(url);
            XMLParser parser = new XMLParser();
            String xml = parser.getXmlFromUrl(url);
            System.out.println("XML yaz");
            System.out.println(xml);
            Document doc = parser.getDomElement(xml);
            if(doc == null)
                System.out.println("doc null dır");
            else
                System.out.println("doc null değildir");
            System.out.println("Selamlar #####");
            //System.out.println(doc.toString());
            NodeList nl = doc.getElementsByTagName(KAYIT);

            ArrayList<HashMap<String, String>> menuItems = new ArrayList<>();
            for (int i = 0; i < nl.getLength(); i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                Element e = (Element) nl.item(i);
                map.put(ID, parser.getValue(e, ID));
                map.put(ADI, parser.getValue(e, ADI));
                map.put(MAAS, parser.getValue(e, MAAS) + " ₺");
                map.put(ACIKLAMA, parser.getValue(e, ACIKLAMA));

                menuItems.add(map);
            }
            return menuItems;
        }

        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> menuItems) {
            super.onPostExecute(menuItems);
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, menuItems,
                    R.layout.list_item,
                    new String[]{ADI, ACIKLAMA, MAAS},
                    new int[]{R.id.adi, R.id.aciklama, R.id.maas}
            );

            setListAdapter(adapter);

            ListView lv = getListView();

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String adi = ((TextView) view.findViewById(R.id.adi)).getText().toString();
                    String maas = ((TextView) view.findViewById(R.id.maas)).getText().toString();
                    String aciklama = ((TextView) view.findViewById(R.id.aciklama)).getText().toString();

                    Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
                    in.putExtra(ADI, adi);
                    in.putExtra(MAAS, maas);
                    in.putExtra(ACIKLAMA, aciklama);
                    startActivity(in);
                }
            });
        }
    }
}