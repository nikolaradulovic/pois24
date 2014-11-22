package com.example.pois24.Sat;

import baze.SQLitePregledi;
import baze.SQLiteRodjendani;

import com.example.pois24.R;
import com.example.pois24.R.anim;
import com.example.pois24.R.id;
import com.example.pois24.R.layout;
import com.example.pois24.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.os.Build;

public class PreglediActivity extends FragmentActivity {

	static TextView staviDatum, staviVreme;
	TextView naslov, ime, datum, vreme;
	EditText unos;
	TimePicker vremeP;
	DatePicker datumP;
	Button sacuvaj, nazad, dajDatum, dajVreme;
	private Handler mHandler = new Handler();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_1pregledi);
		

		naslov = (TextView) findViewById(R.id.txtPregledNaslov);
		ime = (TextView) findViewById(R.id.txtPregledIme);
		unos = (EditText) findViewById(R.id.edtPregledUnos);
		// datum = (TextView) findViewById(R.id.txtDatum);
		// datumP = (DatePicker) findViewById(R.id.dpDatumPr);
		// vreme = (TextView) findViewById(R.id.txtVreme);
		// vremeP = (TimePicker) findViewById(R.id.tpVremePr);
		sacuvaj = (Button) findViewById(R.id.btnSacuvajBroj);
		nazad = (Button) findViewById(R.id.btnNazadRodjendan);
		dajDatum = (Button) findViewById(R.id.izaberiDane);
		dajVreme = (Button) findViewById(R.id.izaberiVreme);
		staviDatum = (TextView) findViewById(R.id.txtDatumPr);
		staviVreme = (TextView) findViewById(R.id.txtVremeP);
		final Animation animDugme = AnimationUtils.loadAnimation(this,
				R.anim.anim_alpha);

		dajVreme.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment newFragment = new Vreme('P');
				newFragment.show(getSupportFragmentManager(), "timePicker");
			}
		});

		nazad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						finish();
					}
				}, 260);
			}
		});

		dajDatum.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment newFragment = new Datum('P');
				newFragment.show(getSupportFragmentManager(), "datePicker");
			}
		});

		sacuvaj.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {
					String imeBolnice = unos.getText().toString();
					String datum = staviDatum.getText().toString();
					String vreme = staviVreme.getText().toString();
					SQLitePregledi bazaPregledi = new SQLitePregledi(PreglediActivity.this);
					@Override
					public void run() {
						// TODO Auto-generated method stub
						if (imeBolnice.equals("") || datum.equals("") || vreme.equals("")) {
							Toast t2 = Toast.makeText(getApplicationContext(),
									"Niste uneli sve podatke",
									Toast.LENGTH_LONG);
							t2.show();
						} else {
//							bazaPregledi.open();
							//bazaPregledi.open();
							bazaPregledi.dodajPregled(imeBolnice, datum, vreme);
							bazaPregledi.close();
							Toast t1 = Toast.makeText(getApplicationContext(),
									"Uspešno ste uneli pregled",
									Toast.LENGTH_LONG);
							t1.show();
						}

					}
				}, 260);
			}
		});
	}
	
//	protected void onPause() {
//		// TODO Auto-generated method stub
//		super.onPause();
//		bazaPregledi.close();
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pregledi, menu);
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
	// View rootView = inflater.inflate(R.layout.fragment_pregledi,
	// container, false);
	// return rootView;
	// }
	// }

}
