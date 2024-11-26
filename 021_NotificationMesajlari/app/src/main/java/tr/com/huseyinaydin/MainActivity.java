package tr.com.huseyinaydin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
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

public class MainActivity extends Activity {

    private static final int NOTIF_ID = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toast.makeText(this, "Mesajınız var.", Toast.LENGTH_LONG).show();

        //NotificationManager notificationManager = ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
        //Notification notumuz = new Notification(R.drawable.mail, "Yeni bir e-posta", System.currentTimeMillis());
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_IMMUTABLE);
        //notumuz.setLatestEventInfo(this, "Yeni bir e-posta", "OKUNMAMIŞ MESAJ UYARISI.", pendingIntent);
        //notificationManager.notify(NOTIF_ID, notumuz);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "email_notifications")
                .setSmallIcon(R.drawable.heart)
                .setContentTitle("Yeni bir e-posta")
                .setContentText("Sevgülünden mesaj var gurban oldooom :-D.")
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());

        /*new AlertDialog.Builder(this)
                .setTitle("MESAJ")
                .setMessage("Mesaj bildirimi!")
                .setIcon(R.drawable.mail)
                .setNeutralButton("Kapat", null)
                .show();*/
    }
}