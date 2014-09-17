package com.example.pois24;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class RodjendanActivity extends ActionBarActivity {

	TextView naslov, izbor, ime, prezime;
	EditText unosIme, unosPrezime;
	DatePicker datum;
	Button sacuvaj, nazad, dajDatum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rodjendan);

		naslov = (TextView) findViewById(R.id.txtRodjendanTitle);
		izbor = (TextView) findViewById(R.id.txtIzaberiDatum);
		ime = (TextView) findViewById(R.id.txtIme);
		unosIme = (EditText) findViewById(R.id.editUnosIme);
		prezime = (TextView) findViewById(R.id.txtPrezime);
		unosPrezime = (EditText) findViewById(R.id.editUnosPrezime);
		// datum = (DatePicker) findViewById(R.id.RodjendanDatum);
		sacuvaj = (Button) findViewById(R.id.btnSacuvajBroj);
		nazad = (Button) findViewById(R.id.btnNazadRodjendan);
		dajDatum = (Button) findViewById(R.id.izaberiDatum);

		nazad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		dajDatum.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment newFragment = new Datum();
				newFragment.show(getFragmentManager(), "datePicker");
			}
		});

		// if (savedInstanceState == null) {
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.container, new PlaceholderFragment()).commit();
		// }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rodjendan, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	// public static class PlaceholderFragment extends Fragment {

	// public PlaceholderFragment() {
	// }

	// @Override
	// public View onCreateView(LayoutInflater inflater, ViewGroup container,
	// Bundle savedInstanceState) {
	// View rootView = inflater.inflate(R.layout.fragment_rodjendan,
	// container, false);
	// return rootView;
	// }
	// }

}