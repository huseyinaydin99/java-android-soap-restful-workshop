package tr.com.huseyinaydin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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

public class MainActivity extends AppCompatActivity {

    private EditText txtTutar;
    private EditText txtKisiSayisi;
    private EditText txtElleGirilenYuzdeOrani;
    private RadioGroup rdoGroupKdv;
    private Button btnHesapla;
    private Button btnTemizle;
    private TextView txtKdv;
    private TextView txtToplamOdenecekTutar;
    private TextView txtKisiSayisiOdenecekMiktar;

    private int radioSeciliDurumId = -1;

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

        txtTutar = findViewById(R.id.txtTutar);
        txtTutar.requestFocus();
        txtKisiSayisi = findViewById(R.id.txtKisiSayisi);
        txtElleGirilenYuzdeOrani = findViewById(R.id.txtElleGirilenYuzdeOrani);
        rdoGroupKdv = findViewById(R.id.RadioGroupKdv);
        btnHesapla = findViewById(R.id.btnHesapla);
        btnHesapla.setEnabled(false);
        btnTemizle = findViewById(R.id.btnTemizle);
        txtKdv = findViewById(R.id.txtKdv);
        txtToplamOdenecekTutar = findViewById(R.id.txtToplamOdenecekTutar);
        txtKisiSayisiOdenecekMiktar = findViewById(R.id.txtKisiSayisiOdenecekMiktar);
        txtElleGirilenYuzdeOrani.setEnabled(false);

        rdoGroupKdv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioOnBes || checkedId == R.id.radioYirmi) {
                    txtElleGirilenYuzdeOrani.setEnabled(false);
                    btnHesapla.setEnabled(txtTutar.getText().length() > 0 && txtKisiSayisi.getText().length() > 0);
                }
                if (checkedId == R.id.radioBaska) {
                    txtElleGirilenYuzdeOrani.setEnabled(true);
                    txtElleGirilenYuzdeOrani.requestFocus();
                    btnHesapla.setEnabled(txtTutar.getText().length() > 0 && txtKisiSayisi.getText().length() > 0
                            && txtElleGirilenYuzdeOrani.getText().length() > 0);
                }

                radioSeciliDurumId = checkedId;
            }
        });

        txtTutar.setOnKeyListener(mKeyListener);
        txtKisiSayisi.setOnKeyListener(mKeyListener);
        txtElleGirilenYuzdeOrani.setOnKeyListener(mKeyListener);

        btnHesapla.setOnClickListener(onClickListener);
        btnTemizle.setOnClickListener(onClickListener);
    }

    private View.OnKeyListener mKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {

            switch (v.getId()) {
                case R.id.txtTutar:
                case R.id.txtKisiSayisi:
                    btnHesapla.setEnabled(txtTutar.getText().length() > 0
                            && txtKisiSayisi.getText().length() > 0);
                    break;
                case R.id.txtElleGirilenYuzdeOrani:
                    btnHesapla.setEnabled(txtTutar.getText().length() > 0
                            && txtKisiSayisi.getText().length() > 0
                            && txtElleGirilenYuzdeOrani.getText().length() > 0);
                    break;
            }
            return false;
        }
    };

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btnHesapla) {
                hesapla();
            } else {
                temizle();
            }
        }
    };

    private void hesapla() {
        Double kdvsizTutar = Double.parseDouble(txtTutar.getText().toString());
        Double totalKisiSayisi = Double.parseDouble(txtKisiSayisi.getText().toString());
        Double kdvOrani = null;
        boolean hataVarmi = false;
        if (kdvsizTutar < 1.0) {
            hataAlertMesajiniGoster("Geçerli Toplam Tutar girin.", txtTutar.getId());
            hataVarmi = true;
        }

        if (totalKisiSayisi < 1.0) {
            hataAlertMesajiniGoster("Kişi sayısı için geçerli bir değer girin.", txtKisiSayisi.getId());
            hataVarmi = true;
        }

        if (radioSeciliDurumId == -1) {
            radioSeciliDurumId = rdoGroupKdv.getCheckedRadioButtonId();
        }
        if (radioSeciliDurumId == R.id.radioOnBes) {
            kdvOrani = 15.00;
        } else if (radioSeciliDurumId == R.id.radioYirmi) {
            kdvOrani = 20.00;
        } else if (radioSeciliDurumId == R.id.radioBaska) {
            kdvOrani = Double.parseDouble(txtElleGirilenYuzdeOrani.getText().toString());
            if (kdvOrani < 1.0) {
                hataAlertMesajiniGoster("Geçerli bir yüzdelik oranı girin", txtElleGirilenYuzdeOrani.getId());
                hataVarmi = true;
            }
        }

        if (!hataVarmi) {
            Double kdvTutarMiktari = ((kdvsizTutar * kdvOrani) / 100);
            Double kdvliToplamTutar = kdvsizTutar + kdvTutarMiktari;
            Double perPersonPays = kdvliToplamTutar / totalKisiSayisi;

            txtKdv.setText(kdvTutarMiktari.toString());
            txtToplamOdenecekTutar.setText(kdvliToplamTutar.toString());
            txtKisiSayisiOdenecekMiktar.setText(perPersonPays.toString());
        }
    }

    private void temizle() {
        txtKdv.setText("");
        txtToplamOdenecekTutar.setText("");
        txtKisiSayisiOdenecekMiktar.setText("");
        txtTutar.setText("");
        txtKisiSayisi.setText("");
        txtElleGirilenYuzdeOrani.setText("");
        rdoGroupKdv.clearCheck();
        rdoGroupKdv.check(R.id.radioOnBes);
        txtTutar.requestFocus();
    }

    private void hataAlertMesajiniGoster(String errorMessage, final int fieldId) {
        new AlertDialog.Builder(this).setTitle("Hata Mesaj˝").setMessage(errorMessage).setNeutralButton("",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                findViewById(fieldId).requestFocus();
            }
        }).show();
    }
}