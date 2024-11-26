package tr.com.huseyinaydin;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

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

public class MainActivity extends ListActivity {

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

        setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.sosyal_medya, android.R.layout.simple_list_item_1));
        final String[] webSayfasininBaglantilari = getResources().getStringArray(R.array.web_adresleri);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int positon, long id) {
                String icerik = webSayfasininBaglantilari[positon];
                Intent webSayfasiniGosterIntent = new Intent(getApplicationContext(), WebSayfasiniGoster.class);
                webSayfasiniGosterIntent.setData(Uri.parse(icerik));
                startActivity(webSayfasiniGosterIntent);
            }
        });
    }
}