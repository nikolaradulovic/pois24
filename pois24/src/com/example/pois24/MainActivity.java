package com.example.pois24;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	Button sat, poruka, stetoskop, poziv, podesavanja;

	// KOMENTAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRRRRRRRRRRRRRRRR!!!!!!!!!!!!!!!!!!!!!!
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sat = (Button) findViewById(R.id.btnSat);
		poruka = (Button) findViewById(R.id.btnPoruka);
		stetoskop = (Button) findViewById(R.id.btnStetoskop);
		poziv = (Button) findViewById(R.id.btnPoziv);
		podesavanja = (Button) findViewById(R.id.btnPodesavanja);

		podesavanja.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openPodesavanjaActivity = new Intent(
						"com.example.pois24.PODESAVANJA");
				startActivity(openPodesavanjaActivity);
			}
		});

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
				Intent openPorukaActivity = new Intent(
						"com.example.pois24.PORUKA");
				startActivity(openPorukaActivity);
			}
		});

		stetoskop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openStetoskopActivity = new Intent(
						"com.example.pois24.STETOSKOP");
				startActivity(openStetoskopActivity);
			}
		});

		poziv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// popUp dialog!

				final Uri broj = PodesavanjaActivity.vratiBroj();

				AlertDialog.Builder builder1 = new AlertDialog.Builder(
						MainActivity.this);
				builder1.setMessage("Da li ste sigurni da �elite da pozovete unesen broj?");
				builder1.setCancelable(true);
				builder1.setPositiveButton("Da",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Intent pozvati = new Intent(Intent.ACTION_CALL);
								pozvati.setData(broj);
								if (pozvati.getData() == null) {
									new AlertDialog.Builder(MainActivity.this)
											.setTitle("Gre�ka")
											.setMessage(
													"U pode�avanjima aplikacije ubacite broj za hitan poziv!")
											.setNeutralButton("OK", null)
											.setIcon(R.drawable.error).show();
								} else {
									startActivity(pozvati);
								}
							}
						});
				builder1.setNegativeButton("Ne",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

				builder1.show();
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
