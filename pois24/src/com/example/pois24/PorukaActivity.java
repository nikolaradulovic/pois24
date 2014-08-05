package com.example.pois24;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PorukaActivity extends ActionBarActivity {

	Button back;
	ListView lista;

	String[] poruke = new String[] { "poruka1", "poruka2", "poruka3",
			"poruka4", "poruka5", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poruka);

		back = (Button) findViewById(R.id.btnBack);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.activity_listview, poruke);

		lista = (ListView) findViewById(R.id.listaPoruka);
		lista.setAdapter(adapter);

		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				switch (position) {
				case 0:
					Intent openPoruka1 = new Intent(
							"com.example.pois24.PORUKA1");
					startActivity(openPoruka1);
					break;
				case 1:
					Intent openPoruka2 = new Intent(
							"com.example.pois24.PORUKA2");
					startActivity(openPoruka2);
					break;
				case 2:
					Intent openPoruka3 = new Intent(
							"com.example.pois24.PORUKA3");
					startActivity(openPoruka3);
					break;
				case 3:
					Intent openPoruka4 = new Intent(
							"com.example.pois24.PORUKA4");
					startActivity(openPoruka4);
					break;
				case 4:
					Intent openPoruka5 = new Intent(
							"com.example.pois24.PORUKA5");
					startActivity(openPoruka5);
					break;
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.poruka, menu);
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
