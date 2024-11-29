package tr.com.huseyinaydin;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
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

    private ConnectivityManager connectivityManager = null;

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

        final TextView txtBaglantiDurumu = findViewById(R.id.txtBaglantiDurumu);
        final ImageView ivBaglantiSimgesi = findViewById(R.id.ivBaglantiSimgesi);

        if (baglantiKontrol()) {
            Toast.makeText(getApplicationContext(), R.string.baglanti_var, Toast.LENGTH_LONG).show();
            ivBaglantiSimgesi.setImageResource(R.drawable.baglanti_var);
            txtBaglantiDurumu.setText(R.string.baglanti_var);
        } else {
            Toast.makeText(getApplicationContext(), R.string.baglanti_yok, Toast.LENGTH_LONG).show();
            ivBaglantiSimgesi.setImageResource(R.drawable.baglanti_yok);
            txtBaglantiDurumu.setText(R.string.baglanti_yok);
        }
    }

    public boolean baglantiKontrol() {
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null) {
            if (connectivityManager.getActiveNetworkInfo().isConnected())
                return true;
        }
        return false;
    }
}