package com.example.pois24;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PodesavanjaActivity extends ActionBarActivity {

	Button sacuvaj;
	EditText broj;
	private static Uri brojTelefona;
	private static boolean dodat = false;

	public static Uri vratiBroj() {
		return brojTelefona;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_podesavanja_poziva);
		sacuvaj = (Button) findViewById(R.id.btnSacuvajBroj);
		broj = (EditText) findViewById(R.id.txtTelefon);

		// if (dodat == true) {
		// setContentView(R.layout.activity_podesavanja_poziva);
		// broj.setText("GSA");
		// } else {
		//
		// }

		sacuvaj.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (broj.getText().toString().matches("[0-9]+")
						&& broj.getText().toString().length() >= 9) {
					brojTelefona = Uri
							.parse("tel:" + broj.getText().toString());
					dodat = true;
					// dialog za uspesno dodavanje broja

					// AlertDialog.Builder ad = new AlertDialog.Builder(
					// PodesavanjaActivity.this);
					// ad.setTitle("Bravo");
					// ad.setMessage("USPEŠNO STE UNELI BROJ");
					// ad.setCancelable(true);
					// ad.setNeutralButton("OK",
					// new DialogInterface.OnClickListener() {
					// public void onClick(DialogInterface dialog,
					// int id) {
					// dialog.cancel();
					// }
					// });
					//
					// AlertDialog alert11 = ad.create();
					// alert11.show();

					Toast t1 = Toast.makeText(getApplicationContext(),
							"USPEŠNO STE DODALI BROJ", Toast.LENGTH_LONG);
					t1.setDuration(5500);
					t1.setGravity(Gravity.CENTER, 0, 0);
					t1.show();

				} else {
					// TODO: handle exception
					AlertDialog.Builder ad = new AlertDialog.Builder(
							PodesavanjaActivity.this);
					ad.setTitle("Unesite ponovo");
					ad.setMessage("MOLIMO UNESITE BROJ PONOVO");
					ad.setCancelable(true);
					ad.setNeutralButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});

					AlertDialog alert11 = ad.create();
					alert11.show();
				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.poziv, menu);
		return true;
	}

	//
	// @Override
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
