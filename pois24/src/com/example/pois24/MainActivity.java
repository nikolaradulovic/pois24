package com.example.pois24;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	Button sat, poruka, stetoskop, poziv;
//KOMENTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRRRR!!!!!!!!!!!!!
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sat = (Button) findViewById(R.id.btnSat);
		poruka = (Button) findViewById(R.id.btnPoruka);
		stetoskop = (Button) findViewById(R.id.btnStetoskop);
		poziv = (Button) findViewById(R.id.btnPoziv);

		sat.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openSatActivity = new Intent("com.example.pois24.SAT");
				startActivity(openSatActivity);

			}
		});

		poruka.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openPorukaActivity = new Intent("com.example.pois24.PORUKA");
				startActivity(openPorukaActivity);
			}
		});

		stetoskop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openStetoskopActivity = new Intent("com.example.pois24.STETOSKOP");
				startActivity(openStetoskopActivity);
			}
		});

		poziv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openPozivActivity = new Intent("com.example.pois24.POZIV");
				startActivity(openPozivActivity);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
