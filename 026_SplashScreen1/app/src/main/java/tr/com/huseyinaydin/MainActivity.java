package tr.com.huseyinaydin;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;

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

    private class DurumKoruyucu{
        private boolean splashScreenGosterimDurumu = true;
    }

    private static final int GOSTERILME_SANIYESI = 10;
    private Dialog splashDialog;

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

        @SuppressWarnings("deprecation")
        DurumKoruyucu durumKoruyucu = (DurumKoruyucu) getLastNonConfigurationInstance();

        if(durumKoruyucu != null && durumKoruyucu.splashScreenGosterimDurumu){
            gosterSplashScreen();
            // setContentView(R.layout.activity_main);
        }else{
            gosterSplashScreen();
            setContentView(R.layout.activity_main);
        }
    }

    private void saklaSplashScreen(){
        if(splashDialog != null){
            splashDialog.dismiss();
            splashDialog = null;
        }
    }

    private void gosterSplashScreen() {
        splashDialog = new Dialog(this);
        splashDialog.setContentView(R.layout.splashscreen);
        splashDialog.setCancelable(false);
        splashDialog.show();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                saklaSplashScreen();
            }
        }, GOSTERILME_SANIYESI * 1000);
    }
}