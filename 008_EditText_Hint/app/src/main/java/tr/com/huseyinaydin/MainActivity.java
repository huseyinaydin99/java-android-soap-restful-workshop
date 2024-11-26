package tr.com.huseyinaydin;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        setIntent(intent);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnClose).setOnClickListener(new KapatmaSinifi());
    }

    private class KapatmaSinifi implements View.OnClickListener {
        public void onClick(View view){
            onStop();
            //finish();
            //finishAffinity();
        }
    }

    @Override
    public void onBackPressed() {
        stopService(new Intent(this, MainActivity.class)); // Arka planda çalışan servisi durdurur
        finishAffinity(); // Mevcut tüm aktiviteleri kapatır
        android.os.Process.killProcess(android.os.Process.myPid()); // İşlemi sonlandırır
        System.exit(0); // Uygulama tamamen kapanır
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isTaskRoot()) {
            finish();
            finishAffinity();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } else {
            super.onBackPressed();
        }
    }
}