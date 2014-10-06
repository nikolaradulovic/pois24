package com.example.pois24.Sat;

import com.example.pois24.R;

import baze.SQLiteRodjendani;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PodaciRodjendanActivity extends ActionBarActivity {

	ListView listaRodjendana;
	SQLiteRodjendani db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_1podaci_rodjendan);
		db = new SQLiteRodjendani(this);
		inicijalizuj();
	}

	public void inicijalizuj() {
		listaRodjendana = (ListView) findViewById(R.id.listaRodjendana);

		int ukupanBroj = db.vratiBrojRodjendana();

		String[] poruke = new String[ukupanBroj];
		if (ukupanBroj > 0) {

			for (int i = 0; i < ukupanBroj; i++) {
				poruke[i] = db.vratiRodjendan(i + 1);
			}

			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
					R.layout.list_row, R.id.title, poruke);

			listaRodjendana.setAdapter(adapter1);
		} else {

		}

	}
}
