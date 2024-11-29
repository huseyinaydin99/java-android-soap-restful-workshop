package tr.com.huseyinaydin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class Web_Sayfasini_GosterActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_sayfasini_goster_fragment);

		Intent launchingIntent = getIntent();
		String content = launchingIntent.getData().toString();

		Web_Sayfasini_GosterFragment viewer = (Web_Sayfasini_GosterFragment) getFragmentManager()
				.findFragmentById(R.id.web_sayfasini_goster_fragment);

		viewer.updateUrl(content);
	}
}