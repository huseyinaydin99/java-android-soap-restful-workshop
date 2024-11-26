package tr.com.huseyinaydin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class MainActivity extends androidx.appcompat.app.AppCompatActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        ActionBar bar = getSupportActionBar();

        bar.addTab(bar.newTab().setIcon(R.drawable.box).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.calendar).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.cart).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.chat).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.gears).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.heart).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.home).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.ic_launcher_foreground).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.key).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.lock).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.mail).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.notepad).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.truck).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.user_female).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.user_male).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.visa).setTabListener(this));

        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_USE_LOGO );
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayShowHomeEnabled(true);
        bar.setDisplayShowTitleEnabled(true);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.activity_main, menu);
        return true;
    }*/

    @Override
    public void onTabSelected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {
        Toast.makeText(getApplicationContext(), "SIRASI : " + tab.getPosition(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

    }
}