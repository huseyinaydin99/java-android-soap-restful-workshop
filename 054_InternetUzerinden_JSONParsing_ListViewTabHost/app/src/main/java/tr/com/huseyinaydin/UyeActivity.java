package tr.com.huseyinaydin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class UyeActivity extends ListActivity {
    // Progress Dialog
    private ProgressDialog pDialog;

    //  JSON Parser nesnesi olusturuluyor
    JSONParser jsonParser = new JSONParser();

    ArrayList<HashMap<String, String>> uyeList;

    // JSONArray'de depolanan uye bilgileri
    JSONArray uye = null;

    // uye JSON web url adresi
    private static final String UYE_URL = "http://falanfelanintermilan.gov.tr/listeleme2.json";

    // Bütün JSON node kök isimleri UYGULAMADAKI TUM SABIT DEGERLER
    private static final String TAG_BIRKAYIT = "item"; // BIR KAYIT - parent node
    private static final String TAG_ID = "id";
    private static final String TAG_ADISOYADISOYADI = "name";
    private static final String TAG_ACIKLAMA = "description";
    private static final String TAG_MAAS = "salary";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uye_list);
        pDialog = new ProgressDialog(this);
        // ListView icin Hashmap
        uyeList = new ArrayList<HashMap<String, String>>();

        // uye elemanları yuklenirken geri plandaki islemler   
        new YukleUye().execute();
    }

    //HTTP Request tarafından Async Task ile geri planda yüklenen PERSONEL mesajları
    class YukleUye extends AsyncTask<String, String, String> {
        //Listedeki elemanların gösterilme öncesinde devreye giren metot
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //pDialog = new ProgressDialog(this);
            pDialog.setMessage("Yükleniyor ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        //getting Personel JSON'u alınıyor
        protected String doInBackground(String... args) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Parametreler
            //List<NameValuePair> params = new ArrayList<NameValuePair>();

            // URL'den string halinde JSON alınıyor
            //JSONObject json = jsonParser.makeHttpRequest(UYE_URL, "GET", params);

            // JSON'dan alınan cevap geri planda seyir defterine kontrol için not ediliyor.
            //Log.d("Üye JSON: ", json.toString());

            //try {
                //uye = json.getJSONArray(TAG_BIRKAYIT);
                // JSON'dan alınan listedeki herbir kayıt için kurulan döngü
                //for (int i = 0; i < uye.length(); i++) {
                    //JSONObject c = uye.getJSONObject(i);

                    // Sadece bir kayda ait veriler değişkenlere atanıyor.
                    /*String id = c.getString(TAG_ID);
                    String adi = c.getString(TAG_ADISOYADISOYADI);
                    String aciklama = c.getString(TAG_ACIKLAMA);
                    String maas = c.getString(TAG_MAAS);*/

                    //Yeni bir HashMap oluşturuluyor
                    HashMap<String, String> map = new HashMap<String, String>();

                    // HashMap key => value ile değerler eşleştiriliyor.
                    map.put(TAG_ID, "1");
                    map.put(TAG_ADISOYADISOYADI, "Hasan Aydın");
                    map.put(TAG_ACIKLAMA, "Selamun Aleyküm");
                    map.put(TAG_MAAS, "9999");

                    //ArrayList'e haritalanan HashList ekleniyor.
                    uyeList.add(map);
                //}
            /*} catch (JSONException e) {
                e.printStackTrace();
            }*/

            return null;
        }

        //Listedeki elemanların gösterilme işlemi bitiminin sonrasında devreye giren metot
        protected void onPostExecute(String file_url) {
            // Bütün kayıtlar gösterildikten sonra progress dşalog kendisini yok ediyor.
            pDialog.dismiss();
            //Geri plandaki işlem güncelleniyor.
            runOnUiThread(new Runnable() {
                public void run() {
                    //ListView içindeki JSON verileri günellenerek biçimlendiriliyor.
                    ListAdapter adapter = new SimpleAdapter(
                            UyeActivity.this, uyeList,
                            R.layout.uye_list_item,
                            new String[]{TAG_ADISOYADISOYADI, TAG_ACIKLAMA, TAG_MAAS},
                            new int[]{R.id.adiSoyadi, R.id.aciklama, R.id.maas}
                    );
                    //  listview güncelleniyor
                    setListAdapter(adapter);
                }
            });
        }
    }
}