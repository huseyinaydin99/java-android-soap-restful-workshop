package tr.com.huseyinaydin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class SingleMenuItemActivity  extends Activity {
	
	static final String ADI = "name";
	static final String MAAS = "salary";
	static final String ACIKLAMA = "description";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        
        Intent in = getIntent();
        
        String adi = in.getStringExtra(ADI);
        String maas = in.getStringExtra(MAAS);
        String aciklama = in.getStringExtra(ACIKLAMA);
        
        TextView lblAdi= findViewById(R.id.adi_etiketi);
        TextView lblMaas = findViewById(R.id.maas_etiketi);
        TextView lblAciklama = findViewById(R.id.aciklama_etiketi);
        
        lblAdi.setText(adi);
        lblMaas.setText(maas);
        lblAciklama.setText(aciklama);
    }
}