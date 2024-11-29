package tr.com.huseyinaydin;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends AppCompatActivity {

    String[] yazi = {"Kutu", "Takvim", "Sepet", "Sohbet", "Kalp", "Ev", "Kilit", "Mektup", "Not", "Kamyon", "Bayan", "Erkek", "Visa", "Tamir"};

    int[] resim = {
            R.drawable.box,
            R.drawable.calendar,
            R.drawable.cart,
            R.drawable.chat,
            R.drawable.heart,
            R.drawable.home,
            R.drawable.lock,
            R.drawable.mail,
            R.drawable.notepad,
            R.drawable.truck,
            R.drawable.user_female,
            R.drawable.user_male,
            R.drawable.visa,
            R.drawable.gears
    };

    private EditText edittext;
    private ListView listview;

    private int textlength = 0;

    private ArrayList<String> yazi_sirala = new ArrayList<String>();
    private ArrayList<Integer> resim_sirala = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        edittext = (EditText) findViewById(R.id.EditText01);
        listview = (ListView) findViewById(R.id.ListView01);
        listview.setAdapter(new OzelCustomAdapter(yazi, resim));

        edittext.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s){
            }

            public void beforeTextChanged(CharSequence s, int start,int count, int after){
            }

            public void onTextChanged(CharSequence s, int start, int before, int count){
                textlength = edittext.getText().length();
                yazi_sirala.clear();
                resim_sirala.clear();

                for (int i = 0; i < yazi.length; i++){
                    if (textlength <= yazi[i].length()) {
                        if (edittext.getText().toString().equalsIgnoreCase((String) yazi[i].subSequence(0, textlength))) {
                            yazi_sirala.add(yazi[i]);
                            resim_sirala.add(resim[i]);
                        }
                    }
                }
                listview.setAdapter(new OzelCustomAdapter(yazi_sirala, resim_sirala));
            }
        });
    }

    private class OzelCustomAdapter extends BaseAdapter {
        String[] data_text;
        int[] data_image;

        OzelCustomAdapter() {}

        OzelCustomAdapter(String[] yazi, int[] resim){
            data_text = yazi;
            data_image = resim;
        }

        OzelCustomAdapter(ArrayList<String> yazi, ArrayList<Integer> resim) {
            data_text = new String[yazi.size()];
            data_image = new int[resim.size()];

            for(int i=0;i<yazi.size();i++){
                data_text[i] = yazi.get(i);
                data_image[i] = resim.get(i);
            }
        }

        public int getCount(){
            return data_text.length;
        }

        public String getItem(int position){
            return null;
        }

        public long getItemId(int position){
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.listview, parent, false);

            TextView textview = row.findViewById(R.id.TextView01);
            ImageView imageview = row.findViewById(R.id.ImageView01);

            textview.setText(data_text[position]);
            imageview.setImageResource(data_image[position]);

            return row;
        }
    }
}