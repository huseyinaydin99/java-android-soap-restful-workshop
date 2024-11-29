package tr.com.huseyinaydin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	
	public Integer[] albumDizisi = {
			R.drawable.resim_01, 
			R.drawable.resim_02,
			R.drawable.resim_03, 
			R.drawable.resim_04,
			R.drawable.resim_05, 
			R.drawable.resim_06,
			R.drawable.resim_07, 
			R.drawable.resim_08,
			R.drawable.resim_09, 
			R.drawable.resim_10,
			R.drawable.resim_11, 
			R.drawable.resim_12,
			R.drawable.resim_13, 
			R.drawable.resim_14,
			R.drawable.resim_15
	};

	// Constructor
	public ImageAdapter(Context c){
		mContext = c;
	}

	@Override
	public int getCount() {
		return albumDizisi.length;
	}

	@Override
	public Object getItem(int position) {
		return albumDizisi[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {			
		ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(albumDizisi[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
	}
}