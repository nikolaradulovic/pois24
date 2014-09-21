package com.example.pois24;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.DialogFragment;
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
import android.os.Build;

public class TvProgramActivity extends ActionBarActivity {

	TextView naslov, naziv, datum, vreme;
	EditText unos;
	Button nazad, sacuvaj, dajDatum, dajVreme;
	DatePicker datumP;
	TimePicker vremeP;
	static TextView staviVreme, staviDatum;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tv_program);

		// naslov = (TextView) findViewById(R.id.txtTVNaslov);
		// naziv = (TextView) findViewById(R.id.txtTVIme);
		unos = (EditText) findViewById(R.id.edtTVUnos);
		// datum = (TextView) findViewById(R.id.txtTVDatum);
		// datumP = (DatePicker) findViewById(R.id.dpDatum);
		// vreme = (TextView) findViewById(R.id.txtTVVreme);
		// vremeP = (TimePicker) findViewById(R.id.tpVreme);
		sacuvaj = (Button) findViewById(R.id.btnSacuvajBroj);
		nazad = (Button) findViewById(R.id.btnNazadRodjendan);
		dajDatum = (Button) findViewById(R.id.izaberiDatum);
		dajVreme = (Button) findViewById(R.id.izaberiVreme);
		staviDatum = (TextView) findViewById(R.id.txtDatumTV);
		staviVreme = (TextView) findViewById(R.id.txtVremeTV);
		final Animation animDugme = AnimationUtils.loadAnimation(this,
				R.anim.anim_alpha);

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

		sacuvaj.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub

					}
				}, 260);
			}
		});
		// if (savedInstanceState == null) {
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.container, new PlaceholderFragment()).commit();
		// }
		dajDatum.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment newFragment = new Datum('T');
				newFragment.show(getFragmentManager(), "datePicker");
			}
		});

		dajVreme.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment newFragment = new Vreme('T');
				newFragment.show(getFragmentManager(), "timePicker");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tv_program, menu);
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
	// View rootView = inflater.inflate(R.layout.fragment_tv_program,
	// container, false);
	// return rootView;
	// }
	// }

}
