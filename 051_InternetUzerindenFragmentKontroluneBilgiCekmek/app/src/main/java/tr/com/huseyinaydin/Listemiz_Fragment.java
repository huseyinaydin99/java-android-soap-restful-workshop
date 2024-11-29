package tr.com.huseyinaydin;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class Listemiz_Fragment extends ListFragment {
	private OnTutSelectedListener tutSelectedListener;

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		String[] links = getResources().getStringArray(R.array.web_adresleri);

		String content = links[position];
		tutSelectedListener.onTutSelected(content);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(ArrayAdapter.createFromResource(getActivity()
				.getApplicationContext(), R.array.video_egitim_kurslari,
				R.layout.listemiz));
	}

	public interface OnTutSelectedListener {
		public void onTutSelected(String tutUrl);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			tutSelectedListener = (OnTutSelectedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " OnTutSelectedListener uygulanmalıdır.");
		}
	}
}