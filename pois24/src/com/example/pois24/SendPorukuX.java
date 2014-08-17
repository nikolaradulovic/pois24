package com.example.pois24;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendPorukuX extends Activity {

	Button btnSend, btnNazad, btnSacuvaj;
	EditText textPhoneNo;
	EditText textSMS;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.poruka_x);
		initialize();

		final SQLitePrimeriPoruka db = new SQLitePrimeriPoruka(this);

		db.dodajPrimer("123");
		db.dodajPrimer("241");
		db.dodajPrimer("245");
		db.dodajPrimer("63");

		final int id = getIntent().getExtras().getInt("id");
		if (db.vratiPrimer(id).toString() != null) {
			textSMS.setText(db.vratiPrimer(id));
		}

		btnSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String phoneNo = textPhoneNo.getText().toString();
				String sms = textSMS.getText().toString();

				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(phoneNo, null, sms, null, null);
					Toast.makeText(getApplicationContext(), "SMS Sent!",
							Toast.LENGTH_LONG).show();
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"SMS faild, please try again later!",
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}

			}
		});

		btnSacuvaj.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = textSMS.getText().toString();
				db.updatePrimer(text, id);
				// TREBALO BI PO ID- da se dodaju!
			}
		});

		btnNazad.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	public void initialize() {
		btnNazad = (Button) findViewById(R.id.btnBack);
		btnSend = (Button) findViewById(R.id.btnPosalji);
		btnSacuvaj = (Button) findViewById(R.id.btnSacuvajPoruku);
		textPhoneNo = (EditText) findViewById(R.id.txtBrojTelefona);
		textSMS = (EditText) findViewById(R.id.txtSMSporukaX);
	}

}
