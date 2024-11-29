package tr.com.huseyinaydin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class FullImageActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.full_image);
		 
        // get intent data
        Intent i = getIntent();
 
        // seçilen image id
        int position = i.getExtras().getInt("pozisyon");
        ImageAdapter imageAdapter = new ImageAdapter(this);
 
        ImageView imageView = findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.albumDizisi[position]);
	}
}