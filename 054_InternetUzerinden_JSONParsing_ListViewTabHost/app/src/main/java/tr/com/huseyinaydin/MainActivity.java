package tr.com.huseyinaydin;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

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

@SuppressWarnings("deprecation")
public class MainActivity  extends TabActivity {
    private static final String PERSONEL_SPEC = "Personel";
    private static final String UYE_SPEC = "Üye";

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

        TabHost tabHost = getTabHost();

        // Personel Sekmesi
        TabHost.TabSpec personelSpec = tabHost.newTabSpec(PERSONEL_SPEC);
        // Sekmenin Simgesi
        personelSpec.setIndicator(PERSONEL_SPEC, getResources().getDrawable(R.drawable.icon_personel));

        Intent personelIntent = new Intent(this, PersonelActivity.class);
        // Sekmenin Icerigi
        personelSpec.setContent(personelIntent);

        // Uye Tab
        TabHost.TabSpec uyeSpec = tabHost.newTabSpec(UYE_SPEC);
        uyeSpec.setIndicator(UYE_SPEC, getResources().getDrawable(R.drawable.icon_uye));

        Intent uyeIntent = new Intent(this, UyeActivity.class);
        // Sekmenin Icerigi
        uyeSpec.setContent(uyeIntent);

        // TabHost'a bütün TabSpec'leri ekle
        tabHost.addTab(personelSpec); // Personel sekmesini ekle
        tabHost.addTab(uyeSpec); // Uye sekmesini ekle
    }
}