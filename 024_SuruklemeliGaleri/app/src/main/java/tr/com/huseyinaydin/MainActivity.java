package tr.com.huseyinaydin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Gallery gallery;
    private ImageAdapter imageAdapter;

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

        setTitle("Android Resim Galerisi Canım");
        gallery = this.findViewById(R.id.galeri1);
        imageAdapter = new ImageAdapter(this);

        gallery.setAdapter(imageAdapter);
        gallery.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View view, int positon, long duration) {
        int kaynakId = (Integer) imageAdapter.getItem(positon);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), kaynakId);
        Toast.makeText(this, "Seçilen resmin: " + getResources().getText(kaynakId) + "\n" + "Yüksekliği: " + bitmap.getHeight() + "\n" + "Genişliği: " + bitmap.getWidth(), Toast.LENGTH_SHORT).show();
    }
}