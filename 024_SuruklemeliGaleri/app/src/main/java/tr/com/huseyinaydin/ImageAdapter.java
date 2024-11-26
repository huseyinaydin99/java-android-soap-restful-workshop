package tr.com.huseyinaydin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context _context = null;

    private final int[] imageIds = {
            //R.drawable._1,
            //R.drawable._2,
            //R.drawable._3,
            //R.drawable._4,
            //R.drawable._5,
            R.drawable._6,
            R.drawable._7,
            R.drawable.box,
            R.drawable.calendar,
            R.drawable.cart,
            R.drawable.chat,
            R.drawable.civciv,
            R.drawable.gears,
            R.drawable.heart,
            R.drawable.home,
            R.drawable.ic_launcher_foreground,
            R.drawable.key,
            R.drawable.lock,
            R.drawable.mail,
            R.drawable.notepad,
            R.drawable.truck,
            R.drawable.user_female,
            R.drawable.user_male,
            R.drawable.visa
    };

    public ImageAdapter (Context context){
        this._context = context;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int index) {
        return imageIds[index];
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public View getView(int position, View view, ViewGroup group) {
        ImageView imageView = new ImageView(_context);
        imageView.setImageResource(imageIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new Gallery.LayoutParams(400, 400));
        return imageView;
    }
}