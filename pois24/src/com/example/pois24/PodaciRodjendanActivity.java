package com.example.pois24;

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
		// String[] poruke = new String[] { db.vratiRodjendan(1),
		// db.vratiRodjendan(2), db.vratiRodjendan(3),
		// db.vratiRodjendan(4), db.vratiRodjendan(5),
		// db.vratiRodjendan(6), db.vratiRodjendan(7),
		// db.vratiRodjendan(8), db.vratiRodjendan(9),
		// db.vratiRodjendan(10)
		//
		// };
		String[] poruke = new String[ukupanBroj];
		if (ukupanBroj > 0) {

			for (int i = 0; i < ukupanBroj; i++) {
				poruke[i] = db.vratiRodjendan(i + 1);
			}

			ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
					R.layout.activity_listview, poruke);

			listaRodjendana.setAdapter(adapter1);
		} else {

		}

	}
}
