package tr.com.huseyinaydin;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import tr.com.huseyinaydin.model.Pojo;

public class ListViewCustomAdapter extends BaseAdapter {

    private ArrayList<Object> itemList;

    public Activity context;
    public LayoutInflater inflater;

    public ListViewCustomAdapter(Activity context, ArrayList<Object> itemList) {
        super();

        this.context = context;
        this.itemList = itemList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imgViewLogo;
        TextView txtViewYazisi;
        TextView txtViewAciklamasi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.items, null);

            holder.imgViewLogo = (ImageView) convertView.findViewById(R.id.imgViewLogo);
            holder.txtViewYazisi = (TextView) convertView.findViewById(R.id.txtViewYazisi);
            holder.txtViewAciklamasi = (TextView) convertView.findViewById(R.id.txtViewAciklamasi);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Pojo bean = (Pojo) itemList.get(position);
        holder.imgViewLogo.setImageResource(bean.getSimge());
        holder.txtViewYazisi.setText(bean.getYazi());
        holder.txtViewAciklamasi.setText(bean.getAciklama());

        return convertView;
    }
}