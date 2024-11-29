package tr.com.huseyinaydin;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;
import java.net.URL;

import tr.com.huseyinaydin.R;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {

    private ImageView imgLogo;
    private ProgressBar yukleniyor;

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

        imgLogo = (ImageView) findViewById(R.id.logo);
        yukleniyor = (ProgressBar) findViewById(R.id.yukleniyor);
    }

    @SuppressWarnings("deprecation")
    public void btnResimleriYukle(View view) {
        //imgLogo.setBackgroundDrawable(loadImageFromWeb("https://cdnuploads.aa.com.tr/uploads/PhotoGallery/2019/11/03/thumbs_b2_4f7a13b8135ccaa390ac4486d317c3a5.jpg"));
        new LoadImageTask().execute("https://cdnuploads.aa.com.tr/uploads/PhotoGallery/2019/11/03/thumbs_b2_4f7a13b8135ccaa390ac4486d317c3a5.jpg");
    }

    public class LoadImageTask extends AsyncTask<String, Void, Void> {
        Drawable imgLoad;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            yukleniyor.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(String... params) {
            imgLoad = loadImageFromWeb(params[0]);
            return null;
        }

        @SuppressWarnings("deprecation")
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (yukleniyor.isShown()) {
                yukleniyor.setVisibility(View.GONE);
                imgLogo.setVisibility(View.VISIBLE);
                imgLogo.setBackgroundDrawable(imgLoad);
            }
        }
    }

    public static Drawable loadImageFromWeb(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}