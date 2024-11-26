package tr.com.huseyinaydin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class WebSayfasiniGosterActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent sonuc = getIntent();
        String content = sonuc.getData().toString();

        WebView viewer = (WebView) findViewById(R.id.webView1);
        viewer.loadUrl(content);
    }
}