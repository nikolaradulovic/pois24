package com.example.pois24.Sat;

import java.util.ArrayList;
import java.util.List;

import com.example.pois24.CustomAdapter;
import com.example.pois24.R;

import baze.SQLiteRodjendani;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PodaciRodjendanActivity extends ActionBarActivity {

	ListView listaRodjendana;
	SQLiteRodjendani db;
	List<_Rodjendan> rodjendani;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_1podaci_rodjendan);
		db = new SQLiteRodjendani(this);
		initialize();
	}

	// private void inicijalizuj() {
	// listaRodjendana = (ListView) findViewById(R.id.listaRodjendana);
	//
	// int ukupanBroj = db.vratiBrojRodjendana();
	//
	// String[] poruke = new String[ukupanBroj];
	// if (ukupanBroj > 0) {
	//
	// for (int i = 0; i < ukupanBroj; i++) {
	// poruke[i] = db.vratiRodjendan(i + 1);
	// }
	//
	// ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
	// R.layout.list_row, R.id.title, poruke);
	//
	// listaRodjendana.setAdapter(adapter1);
	// } else {
	//
	// }
	//
	// }

	private void initialize() {
		listaRodjendana = (ListView) findViewById(R.id.listaRodjendana);

		napuniRodjendane();

		if (rodjendani.isEmpty()) {

		} else {
			CustomAdapter ca = new CustomAdapter(this, R.layout.list_row,
					R.id.title, rodjendani);

			listaRodjendana.setAdapter(ca);
		}

	}

	private void napuniRodjendane() {
		int size = db.vratiBrojRodjendana();

		rodjendani = new ArrayList<_Rodjendan>();

		for (int i = 0; i < size; i++) {
			String x = db.vratiRodjendan(i + 1);
			if (!x.isEmpty()) {
				String[] II_PP_DD = x.split(":::");

				String date = II_PP_DD[2];
				String[] dateArray = date.split("/");

				int dd = Integer.parseInt(dateArray[0]);
				int mm = Integer.parseInt(dateArray[1]);
				int yy = Integer.parseInt(dateArray[2]);

				_Rodjendan r = new _Rodjendan(II_PP_DD[0], II_PP_DD[1], dd, mm,
						yy);
				rodjendani.add(r);
			}

		}
	}
}
