package tr.com.huseyinaydin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final CharSequence[] digitList = {"Android", "iPhone", "Nokia"};

        AlertDialog.Builder alt_bid = new AlertDialog.Builder(this);
        alt_bid.setIcon(R.drawable.visa);
        alt_bid.setTitle("Lütfen seçimlerinizi yapınız.");

        alt_bid.setMultiChoiceItems(digitList, new boolean[]{true, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(getApplicationContext(), "Seçilen birşey var.", Toast.LENGTH_SHORT).show();
                    }
                });
        alt_bid.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListView list = ((AlertDialog) dialog).getListView();
                StringBuilder sb = new StringBuilder();

                for (int position = 0; position < list.getCount(); position++) {
                    boolean seciliMi = list.isItemChecked(position);
                    if (seciliMi) {
                        if (sb.length() > 0) {
                            sb.append(", ");
                        }
                        sb.append(list.getItemAtPosition(position));
                    }
                }
                Toast.makeText(getApplicationContext(), "SEÇİMİNİZ : " + sb.toString(), Toast.LENGTH_LONG).show();
            }
        });

        alt_bid.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "İptal düğmesine bastınız.", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alt_bid.create();
        alertDialog.show();
    }
}