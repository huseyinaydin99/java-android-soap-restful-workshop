package tr.com.huseyinaydin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ustKismiHazirla("ViewStub başlığı tr.com.huseyinaydin.********* :D");
    }

    public void ustKismiHazirla(String baslikYazisi) {
        ViewStub stub = findViewById(R.id.vsHeader);
        View inflated = stub.inflate();

        TextView txtTitle = inflated.findViewById(R.id.txtHeading);
        txtTitle.setText(baslikYazisi);
    }

    public void metot1() {}

    public void metot2() {}
}