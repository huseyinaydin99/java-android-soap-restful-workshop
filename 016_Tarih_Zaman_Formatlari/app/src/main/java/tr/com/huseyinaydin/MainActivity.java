package tr.com.huseyinaydin;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Date;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Android
 * @since 1994
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

        TextView textView1 = findViewById(R.id.textview1);
        TextView textView2 = findViewById(R.id.textview2);
        TextView textView3 = findViewById(R.id.textview3);
        TextView textView4 = findViewById(R.id.textview4);
        TextView textView5 = findViewById(R.id.textview5);

        String format = "MM/dd/yy hh:mm a";
        Date tarih = Calendar.getInstance().getTime();
        textView1.setText("Tarih Formatı : " + DateFormat.format(format, tarih));

        format = "MMM dd, yyyy h:mm aa";
        textView2.setText("Tarih Formatı : " + DateFormat.format(format, tarih));

        format = "MMMM dd, yyyy h:mmaa";
        textView3.setText("Tarih Formatı : " + DateFormat.format(format, tarih));

        format = "E, MMMM dd, yyyy h:mm:ss aa";
        textView4.setText("Tarih Formatı : " + DateFormat.format(format, tarih));

        format = "EEEE, MMMM dd, yyyy h:mm aa";
        textView5.setText("Tarih Formatı : " + DateFormat.format(format, tarih));
    }
}