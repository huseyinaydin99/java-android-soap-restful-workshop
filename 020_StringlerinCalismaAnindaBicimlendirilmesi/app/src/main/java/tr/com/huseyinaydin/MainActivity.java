package tr.com.huseyinaydin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {
    private Button dugmemiz;

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

        dugmemiz = (Button) findViewById(R.id.button1);
        dugmemiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formatStrings();
            }
        });
    }

    public void formatStrings(){
        Random rasgele = new Random();
        int kacGunIcinde = rasgele.nextInt(7);

        String strIletisimeGecmeTarihiFormat = getResources().getString(R.string.iletisimeGecmeMesaji);
        String strIletisimMesaji = String.format(strIletisimeGecmeTarihiFormat, kacGunIcinde);

        final TextView tvIletisimMesaji = (TextView) findViewById(R.id.tvIletisimMesaji);
        tvIletisimMesaji.setText(strIletisimMesaji);

        final Spinner spinnerpozisyon = (Spinner) findViewById(R.id.spinnerposizyon);
        String posizyon = spinnerpozisyon.getSelectedItem().toString();

        if(posizyon.equalsIgnoreCase(getResources().getString(R.string.kodGelistiricisi)) == true) {
            posizyon = posizyon + getResources().getString(R.string.ihtiyacDurumu);
        }

        String strPozisyonFormat =  getResources().getString(R.string.posizyonMesaji);
        String strPosizyonMesaji = String.format(strPozisyonFormat, posizyon);

        final TextView tvPosizyonMesaji = (TextView) findViewById(R.id.tvPozisyonMesaji);
        tvPosizyonMesaji.setText(strPosizyonMesaji);

        final EditText etAdiSoyadi = (EditText) findViewById(R.id.etAdiSoyadi);
        String adayinAdiSoyadi = etAdiSoyadi.getText().toString();

        final Spinner spinnerTecrube = (Spinner) findViewById(R.id.SpinnerTecrube);
        String tecrube = spinnerTecrube.getSelectedItem().toString();

        String strTecrubeFormat =  getResources().getString(R.string.tecrubeMesaji);
        String strTecrubeMesaji = String.format(strTecrubeFormat, adayinAdiSoyadi, tecrube);

        final TextView tvTecrubeMesaji = (TextView) findViewById(R.id.tvTecrubeMesaji);
        tvTecrubeMesaji.setText(strTecrubeMesaji);

        String strTecrubeFormat2 =  getResources().getString(R.string.tecrubeMesaji2);
        String strTecrubeMesaji2 = String.format(strTecrubeFormat2, adayinAdiSoyadi, tecrube);

        final TextView tvTecrubeMesaji2 = (TextView) findViewById(R.id.tvTecrubeMesaji2);
        tvTecrubeMesaji2.setText(strTecrubeMesaji2);
    }
}