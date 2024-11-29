package tr.com.huseyinaydin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class AddEditCountry extends Activity {

    private long rowID;
    private EditText nameEt;
    private EditText capEt;
    private EditText codeEt;

    private String nameEt_ = "", capEt_ = "", codeEt_ = "";
    private Bundle bundle = null;
    private DatabaseConnector dbConnector = new DatabaseConnector(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_country);

        nameEt = findViewById(R.id.nameEdit);
        capEt = findViewById(R.id.capEdit);
        codeEt = findViewById(R.id.codeEdit);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            rowID = extras.getLong("row_id");
            nameEt.setText(extras.getString("name"));
            capEt.setText(extras.getString("cap"));
            codeEt.setText(extras.getString("code"));
        }

        Button saveButton = findViewById(R.id.saveBtn);
        saveButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                if (nameEt.getText().length() != 0) {
                    /*DatabaseConnector dbConnector = new DatabaseConnector(getApplicationContext());

                    if (getIntent().getExtras() == null) {
                        nameEt_ = nameEt.getText().toString();
                        codeEt_ = codeEt.getText().toString();
                        capEt_ = capEt.getText().toString();
                    } else {
                        dbConnector.updateContact(rowID,
                                nameEt.getText().toString(),
                                capEt.getText().toString(),
                                codeEt.getText().toString());
                    }*/

                    nameEt_ = nameEt.getText().toString();
                    codeEt_ = codeEt.getText().toString();
                    capEt_ = capEt.getText().toString();
                    bundle = getIntent().getExtras();

                    AsyncTask<Object, Object, Object> saveContactTask =
                            new AsyncTask<Object, Object, Object>() {
                                @Override
                                protected Object doInBackground(Object... params) {
                                    saveContact();
                                    return null;
                                }

                                @Override
                                protected void onPostExecute(Object result) {
                                    finish();
                                }
                            };

                    saveContactTask.execute();
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(AddEditCountry.this);
                    alert.setTitle(R.string.errorTitle);
                    alert.setMessage(R.string.errorMessage);
                    alert.setPositiveButton(R.string.errorButton, null);
                    alert.show();
                }
            }
        });
    }

    private void saveContact() {
        if (bundle == null) {
            dbConnector.insertContact(
                    nameEt_,
                    capEt_,
                    codeEt_);
        } else {
            dbConnector.updateContact(rowID,
                    nameEt_,
                    capEt_,
                    codeEt_);
        }
    }
}