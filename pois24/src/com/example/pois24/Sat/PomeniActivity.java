package com.example.pois24.Sat;

import baze.SQLitePomeni;

import com.example.pois24.R;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PomeniActivity extends ActionBarActivity {
	
	static TextView  ispisDatum;
	TextView naslov,ime, mesto;
	EditText unosIme, unosMesto;
	DatePicker datum;
	Button izaberiDatum, sacuvaj, nazad;
	private Handler mHandler = new Handler();
	private SQLitePomeni db = new SQLitePomeni(this);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pomeni);
		
		naslov = (TextView) findViewById(R.id.txtPomeniNaslov);
		ime = (TextView) findViewById(R.id.txtImePomen);
		unosIme = (EditText) findViewById(R.id.editUnosPomenIme);
		mesto = (TextView) findViewById(R.id.txtMestoPomen);
		unosMesto = (EditText) findViewById(R.id.editUnosPomenMesto);
		izaberiDatum = (Button) findViewById(R.id.izaberiDane);
		ispisDatum = (TextView) findViewById(R.id.txtIspisDatum);
		sacuvaj = (Button) findViewById(R.id.btnSacuvajBroj);
		nazad = (Button) findViewById(R.id.btnNazadRodjendan);
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
		
		izaberiDatum.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				DialogFragment newFragment = new Datum('O');
				newFragment.show(getSupportFragmentManager(), "datePicker");

			}
		});
		
		sacuvaj.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {
				String ime = unosIme.getText().toString();
				String mesto = unosMesto.getText().toString();
				String datum = ispisDatum.getText().toString();
					@Override
					public void run() {
						if (ime.equals("") || mesto.equals("") || datum.equals("")) {
							Toast t2 = Toast.makeText(getApplicationContext(),
									"NISTE UNELI SVE PODATKE",
									Toast.LENGTH_LONG);
							t2.show();
						} else {
							db.dodajPomen(ime, mesto, datum);
							Toast t1 = Toast.makeText(getApplicationContext(),
									"USPE�NO STE DODALI POMEN",
									Toast.LENGTH_LONG);
							t1.show();
						}
						// TODO Auto-generated method stub		
						finish();
					}
				}, 260);
			}
		});
	}
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		db.close();
	}
}
