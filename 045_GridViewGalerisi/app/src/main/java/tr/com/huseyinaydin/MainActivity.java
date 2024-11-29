package tr.com.huseyinaydin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        GridView gridView = findViewById(R.id.gridView1);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View gorunum, int position, long id) {
                Toast.makeText(MainActivity.this, "NO : " + position, Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(), "NO : " + position, Toast.LENGTH_LONG).show();

                //Image Id FullScreenActivity için gönderiliyor
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                //Dizi index'i geçiriliyor.
                i.putExtra("pozisyon", position);
                startActivity(i);
            }
        });
    }
}