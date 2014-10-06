package com.example.pois24.Stetoskop;

import com.example.pois24.R;
import com.example.pois24.R.anim;
import com.example.pois24.R.id;
import com.example.pois24.R.layout;
import com.example.pois24.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class StetoskopActivity extends ActionBarActivity {

	Button btnBack;
	Button terapija;
	Button terapija2;
	Button terapija3;
	Button terapija4;
	Button terapija5;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_3stetoskop);

		btnBack = (Button) findViewById(R.id.btnBackTerapija);
		terapija = (Button) findViewById(R.id.btnTerapija1);
		terapija2 = (Button) findViewById(R.id.btnTerapija2);
		terapija3 = (Button) findViewById(R.id.btnTerapija3);
		terapija4 = (Button) findViewById(R.id.btnTerapija4);
		terapija5 = (Button) findViewById(R.id.btnTerapija5);
		final Animation animDugme = AnimationUtils.loadAnimation(this,
				R.anim.anim_alpha);

		btnBack.setOnClickListener(new View.OnClickListener() {

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

		terapija.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent openTerapijaActivity = new Intent(
						"com.example.pois24.TERAPIJA1");
				startActivity(openTerapijaActivity);
			}
		});

		terapija2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent openTerapijaActivity = new Intent(
						"com.example.pois24.TERAPIJA1");
				startActivity(openTerapijaActivity);
			}
		});

		terapija3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent openTerapijaActivity = new Intent(
						"com.example.pois24.TERAPIJA1");
				startActivity(openTerapijaActivity);
			}
		});

		terapija4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent openTerapijaActivity = new Intent(
						"com.example.pois24.TERAPIJA1");
				startActivity(openTerapijaActivity);
			}
		});

		terapija5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent openTerapijaActivity = new Intent(
						"com.example.pois24.TERAPIJA1");
				startActivity(openTerapijaActivity);
			}
		});

		// if (savedInstanceState == null) {
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.btnBackTerapije, new PlaceholderFragment()).commit();
		// }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stetoskop, menu);
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
}
