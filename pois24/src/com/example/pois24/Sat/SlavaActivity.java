package com.example.pois24.Sat;

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
import android.widget.Spinner;
import android.widget.TextView;

public class SlavaActivity extends ActionBarActivity {
	
	static TextView ispis;
	TextView naslov, ime, koSlavi;
	EditText unosIme,unosKo;
	Button izaberiDatum, sacuvaj, nazad;
	DatePicker datum;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slava);
		
		naslov = (TextView) findViewById(R.id.txtSlaveTitle);
		ime = (TextView) findViewById(R.id.txtImeSlave);
		unosIme = (EditText) findViewById(R.id.editUnosSlave);
		izaberiDatum = (Button) findViewById(R.id.izaberiDane);
		ispis = (TextView) findViewById(R.id.txtIspisDatum);
		koSlavi = (TextView) findViewById(R.id.txtKoSlavi);
		unosKo = (EditText) findViewById(R.id.editKoSlavi);
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

				DialogFragment newFragment = new Datum('S');
				newFragment.show(getSupportFragmentManager(), "datePicker");

			}
		});
	}
	
	
}
