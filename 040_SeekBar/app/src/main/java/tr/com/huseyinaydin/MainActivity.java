package tr.com.huseyinaydin;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

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

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final Button rotatingButton = findViewById(R.id.rotatingButton);

        SeekBar seekBar;
        seekBar = findViewById(R.id.translationX);
        seekBar.setMax(400);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rotatingButton.setTranslationX((float) progress);
            }
        });

        seekBar = findViewById(R.id.translationY);
        seekBar.setMax(800);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                rotatingButton.setTranslationY((float) progress);
            }
        });

        seekBar = findViewById(R.id.scaleX);
        seekBar.setMax(50);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rotatingButton.setScaleX((float) progress / 10f);
            }
        });

        seekBar = findViewById(R.id.scaleY);
        seekBar.setMax(50);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                rotatingButton.setScaleY((float) progress / 10f);
            }
        });

        seekBar = findViewById(R.id.rotationX);
        seekBar.setMax(360);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                rotatingButton.setRotationX((float) progress);
            }
        });

        seekBar = findViewById(R.id.rotationY);
        seekBar.setMax(360);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                rotatingButton.setRotationY((float) progress);
            }
        });

        seekBar = findViewById(R.id.rotationZ);
        seekBar.setMax(360);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                rotatingButton.setRotation((float) progress);
            }
        });
    }
}