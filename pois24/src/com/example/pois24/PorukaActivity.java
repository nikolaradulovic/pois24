package com.example.pois24;

import java.util.LinkedList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PorukaActivity extends ActionBarActivity {

	Button back;
	ListView lista;
	// ucitavace se iz baze mozda
	int brojPoruka = 10;

	String[] poruke = new String[] { "Poruka 1", "Poruka 2", "Poruka 3",
			"Poruka 4", "Poruka 5", "Poruka 6", "Poruka 7", "Poruka 8",
			"Poruka 9", "Poruka 10" };

	LinkedList<Intent> listaIntentova = new LinkedList<Intent>();

	public void napuniListuIntentova() {
		for (int i = 1; i < brojPoruka; i++) {
			Intent i1 = new Intent("com.example.pois24.PORUKAX");
			Bundle b1 = new Bundle();
			b1.putInt("id", i);
			i1.putExtras(b1);
			listaIntentova.add(i1);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Slanje hitnih poruka");
		getSupportActionBar().setIcon(R.drawable.slika11);
		napuniListuIntentova();
		setContentView(R.layout.activity_poruka);

		initialize();

		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				startActivity(listaIntentova.get(position));
			}
		});

	}

	public void initialize() {
		back = (Button) findViewById(R.id.btnBack);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				R.layout.activity_listview, poruke);
		lista = (ListView) findViewById(R.id.listaPoruka);

		lista.setAdapter(adapter1);
	}

}
