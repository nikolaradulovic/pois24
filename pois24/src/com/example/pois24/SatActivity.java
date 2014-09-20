package com.example.pois24;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class SatActivity extends ActionBarActivity {

	TextView naslov, prazan;
	Button tv, rodjendani, pregledi, nazad, uneto;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_sat);
		initialize();
		final Animation animDugme = AnimationUtils.loadAnimation(this,
				R.anim.anim_alpha);

		uneto.setOnClickListener(new View.OnClickListener() {

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

		nazad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		rodjendani.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Intent openRodjendanActivity = new Intent(
								"com.example.pois24.RODJENDAN");
						startActivity(openRodjendanActivity);
					}
				}, 260);

			}
		});

		tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Intent openTvProgramActivity = new Intent(
								"com.example.pois24.TVPROGRAM");
						startActivity(openTvProgramActivity);
					}
				}, 260);

			}
		});

		pregledi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Intent openPreglediActivity = new Intent(
								"com.example.pois24.PREGLEDI");
						startActivity(openPreglediActivity);
					}
				}, 260);

			}
		});

	}

	public void initialize() {

		naslov = (TextView) findViewById(R.id.sat_naslov);
		prazan = (TextView) findViewById(R.id.prazan);
		rodjendani = (Button) findViewById(R.id.btnRodjendani);
		tv = (Button) findViewById(R.id.btnTvProgram);
		pregledi = (Button) findViewById(R.id.btnPregledi);
		uneto = (Button) findViewById(R.id.btnUneto);
		nazad = (Button) findViewById(R.id.btnNazad);

	}
}
