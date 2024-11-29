package tr.com.huseyinaydin;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class CountryList extends ListActivity {

    public static final String ROW_ID = "row_id";
    private ListView conListView;
    private CursorAdapter conAdapter;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        conListView = getListView();
        conListView.setOnItemClickListener(viewConListener);

        // TextView için haritalama yapılıyor
        String[] from = new String[]{"name"};
        int[] to = new int[]{R.id.countryTextView};
        conAdapter = new SimpleCursorAdapter(CountryList.this, R.layout.country_list, null, from, to);
        setListAdapter(conAdapter); // adapter hazirlaniyor
    }

    @Override
    protected void onResume() {
        super.onResume();
        new GetContacts().execute((Object[]) null);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onStop() {
        Cursor cursor = conAdapter.getCursor();

        if (cursor != null)
            cursor.deactivate();

        conAdapter.changeCursor(null);
        super.onStop();
    }

    private class GetContacts extends AsyncTask<Object, Object, Cursor> {
        DatabaseConnector dbConnector = new DatabaseConnector(CountryList.this);
        @Override
        protected Cursor doInBackground(Object... params) {
            dbConnector.open();
            return dbConnector.getAllContacts();
        }

        @Override
        protected void onPostExecute(Cursor result) {
            conAdapter.changeCursor(result); // adapter için Cursor hazırlanıyor
            dbConnector.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.country_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent addContact = new Intent(CountryList.this, AddEditCountry.class);
        startActivity(addContact);
        return super.onOptionsItemSelected(item);
    }

    OnItemClickListener viewConListener = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            Intent viewCon = new Intent(CountryList.this, ViewCountry.class);
            viewCon.putExtra(ROW_ID, arg3);
            startActivity(viewCon);
        }
    };
}