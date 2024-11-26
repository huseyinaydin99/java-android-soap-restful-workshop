package tr.com.huseyinaydin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private String strEmailAdres;
    private EditText kulllaniciAdi, parolasi;
    private String KULLANICIADI, PAROLASI;
    private Button dugmemiz;
    private String mailDenetlemeFormati = "^\\D.+@.+\\.[a-z]+";

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

        kulllaniciAdi = (EditText) findViewById(R.id.editTextKullaniciAdi);
        KULLANICIADI = kulllaniciAdi.getText().toString();
        parolasi = (EditText) findViewById(R.id.editTextParola);
        PAROLASI = parolasi.getText().toString();
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        dugmemiz = (Button) findViewById(R.id.btnValidate);

        dugmemiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnValidateEmailAddress(v);
            }
        });
    }

    public void btnValidateEmailAddress(View v) {
        strEmailAdres = editTextEmail.getText().toString().trim();
        Matcher matcherObj = Pattern.compile(mailDenetlemeFormati).matcher(strEmailAdres);

        if (matcherObj.matches())
            Toast.makeText(v.getContext(), "Girilen e-posta adresi : " + strEmailAdres + " geçerlidir.", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(v.getContext(), "Girilen e-posta adresi : " + strEmailAdres + " geçersizdir.", Toast.LENGTH_SHORT).show();
            editTextEmail.setError("Hatalı e-posta girişi yaptınız.");
        }

        if (kulllaniciAdi.getText().length() == 0)
            kulllaniciAdi.setError("Lütfen kullanıcı adınızı giriniz.");

        if (parolasi.getText().length() == 0) {
            parolasi.setFocusableInTouchMode(true);
            parolasi.requestFocus();
            parolasi.setError("Lütfen şifrenizi giriniz.");
        }
    }
}