package com.example.pois24;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PodesavanjaActivity extends ActionBarActivity {

	Button sacuvaj;
	EditText broj;
	TextView txtHitanBroj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_podesavanja_poziva);
		initialize();

		sacuvaj.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (broj.getText().toString().matches("[0-9]+")
						&& broj.getText().toString().length() >= 9) {

					try {
						FileOutputStream fos = openFileOutput("broj.txt",
								Context.MODE_PRIVATE);
						fos.write(broj.getText().toString().getBytes());
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

					finish();

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

	private void initialize() {
		sacuvaj = (Button) findViewById(R.id.btnSacuvajBroj);
		broj = (EditText) findViewById(R.id.txtTelefon);
		txtHitanBroj = (TextView) findViewById(R.id.txtHitanBroj);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		txtHitanBroj.setText(vratiBroj());
	}

	public String vratiBroj() {

		String brojIzFajla = "";

		try {
			BufferedReader inputReader = new BufferedReader(
					new InputStreamReader(openFileInput("broj.txt")));
			String inputString;
			StringBuffer stringBuffer = new StringBuffer();
			while ((inputString = inputReader.readLine()) != null) {
				stringBuffer.append(inputString + "\n");
			}
			brojIzFajla = stringBuffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return brojIzFajla;
	}
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // TODO Auto-generated method stub
	// getMenuInflater().inflate(R.menu.poziv, menu);
	// return true;
	// }
	//
	// //
	// // @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// // Handle action bar item clicks here. The action bar will
	// // automatically handle clicks on the Home/Up button, so long
	// // as you specify a parent activity in AndroidManifest.xml.
	// int id = item.getItemId();
	// if (id == R.id.action_settings) {
	// return true;
	// }
	// return super.onOptionsItemSelected(item);
	// }

}
