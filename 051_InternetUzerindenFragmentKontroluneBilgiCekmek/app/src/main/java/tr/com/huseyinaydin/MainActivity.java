package tr.com.huseyinaydin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

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

public class MainActivity extends AppCompatActivity implements Listemiz_Fragment.OnTutSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.listemiz_fragment);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }

    @Override
    public void onTutSelected(String tutUrl) {
        Web_Sayfasini_GosterFragment viewer = (Web_Sayfasini_GosterFragment) getFragmentManager()
                .findFragmentById(R.id.web_sayfasini_goster_fragment);
        viewer.updateUrl(tutUrl);
        /*if (viewer == null || !viewer.isInLayout()) {
            Intent showContent = new Intent(getApplicationContext(), Web_Sayfasini_GosterActivity.class);
            showContent.setData(Uri.parse(tutUrl));
            startActivity(showContent);
        } else {
            viewer.updateUrl(tutUrl);
        }*/
    }
}