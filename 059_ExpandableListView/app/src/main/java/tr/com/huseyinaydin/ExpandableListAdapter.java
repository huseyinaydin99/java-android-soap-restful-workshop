package tr.com.huseyinaydin;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

	private Context _context;
	private List<String> _listeVeriBaslik; // baslik etiketi 
	// cocuk veri  baslik formatinda  - cocuk etiketi
	private HashMap<String, List<String>> _listeVeriCocuk;

	public ExpandableListAdapter(Context context, List<String> listVeriBaslik, HashMap<String, List<String>> listChildData) {
		this._context = context;
		this._listeVeriBaslik = listVeriBaslik;
		this._listeVeriCocuk = listChildData;
	}

	@Override
	public Object getChild(int groupPosition, int childPosititon) {
		return this._listeVeriCocuk.get(this._listeVeriBaslik.get(groupPosition)).get(childPosititon);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		final String childText = (String) getChild(groupPosition, childPosition);

		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_item, null);
		}

		TextView txtListChild = convertView.findViewById(R.id.lblListItem);

		txtListChild.setText(childText);
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return this._listeVeriCocuk.get(this._listeVeriBaslik.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return this._listeVeriBaslik.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return this._listeVeriBaslik.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		String headerTitle = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_group, null);
		}

		TextView lblListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
		lblListHeader.setTypeface(null, Typeface.BOLD);
		lblListHeader.setText(headerTitle);

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}
}