package tr.com.huseyinaydin;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class BizimAdapterSinifimiz extends BaseAdapter {
	private static ArrayList<KayitBilgileri> kisiArrayListesi;
	
	private LayoutInflater mInflater;

	public BizimAdapterSinifimiz(Context context, ArrayList<KayitBilgileri> results) {
		kisiArrayListesi = results;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return kisiArrayListesi.size();
	}

	public Object getItem(int position) {
		return kisiArrayListesi.get(position);
	}

	public long getItemId(int position) {
		return position;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		class Goruntu {
			TextView txtAdiSoyadi;
			TextView txtSehir;
			TextView txtTelefon;
		}
		
		Goruntu goruntu;
		
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.bize_ozel_satirlar, null);
			goruntu = new Goruntu();
			goruntu.txtAdiSoyadi = convertView.findViewById(R.id.adiSoyadi);
			goruntu.txtSehir = convertView.findViewById(R.id.sehir);
			goruntu.txtTelefon = convertView.findViewById(R.id.telefon);

			convertView.setTag(goruntu);
		} else {
			goruntu = (Goruntu) convertView.getTag();
		}
		
		goruntu.txtAdiSoyadi.setText(kisiArrayListesi.get(position).getAdiSoyadi());
		goruntu.txtSehir.setText(kisiArrayListesi.get(position).getSehir());
		goruntu.txtTelefon.setText(kisiArrayListesi.get(position).getTelefon());

		return convertView;
	}
}