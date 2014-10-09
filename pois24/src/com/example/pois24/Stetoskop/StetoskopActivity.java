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

	Button ujutru;
	Button upodne;
	Button uvece;
	Button opciono;
	Button nazad;
	
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_3stetoskop);

		ujutru = (Button) findViewById(R.id.btnUjutru);
		upodne = (Button) findViewById(R.id.btnUpodne);
		uvece = (Button) findViewById(R.id.btnUvece);
		opciono = (Button) findViewById(R.id.btnOpciono);
		nazad = (Button) findViewById(R.id.btnNazad);
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

		ujutru.setOnClickListener(new View.OnClickListener() {
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
