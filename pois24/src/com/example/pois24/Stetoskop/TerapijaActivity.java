package com.example.pois24.Stetoskop;

import com.example.pois24.R;
import com.example.pois24.R.anim;
import com.example.pois24.R.id;
import com.example.pois24.R.layout;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class TerapijaActivity extends ActionBarActivity {

	Button sacuvaj, nazad;
	EditText unos;
	TextView naslov, kada, kolicina, aktivna;
	Spinner spin1, spin2;
	CheckBox aktivna_ck;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Podesavanja terapije");
		setContentView(R.layout.activity_3terapija1);

		naslov = (TextView) findViewById(R.id.terapijaNaziv);
		unos = (EditText) findViewById(R.id.unesiTxt);
		aktivna_ck = (CheckBox) findViewById(R.id.chbAktivna);
		aktivna = (TextView) findViewById(R.id.terapijaAct);
		kolicina = (TextView) findViewById(R.id.terapijaKolicina);
		kada = (TextView) findViewById(R.id.terapijaInt);
		spin1 = (Spinner) findViewById(R.id.combo_kada);
		spin2 = (Spinner) findViewById(R.id.combo_koliko);
		sacuvaj = (Button) findViewById(R.id.btnSacuvajBroj);
		nazad = (Button) findViewById(R.id.btnNazadPodesavanja);
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
						finish();
					}
				}, 260);

			}
		});

	}

	private void initialize() {

	}

}
