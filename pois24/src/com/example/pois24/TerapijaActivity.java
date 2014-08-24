package com.example.pois24;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class TerapijaActivity extends ActionBarActivity {
	
	Button sacuvaj, nazad;
	EditText unos;
	TextView naslov, kada, kolicina, aktivna; 
	Spinner spin1, spin2;
	CheckBox aktivna_ck;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Podesavanja terapije");
		setContentView(R.layout.activity_terapija1);
		
		naslov = (TextView) findViewById(R.id.terapijaNaziv);
		unos = (EditText) findViewById(R.id.unesiTxt);
		aktivna_ck = (CheckBox) findViewById(R.id.chbAktivna);
		aktivna = (TextView) findViewById(R.id.terapijaAct);
		kolicina = (TextView) findViewById(R.id.terapijaKolicina);
		kada = (TextView) findViewById(R.id.terapijaInt);
		spin1 = (Spinner) findViewById(R.id.combo_kada);
		spin2 = (Spinner) findViewById(R.id.combo_koliko);
		sacuvaj = (Button) findViewById(R.id.btnSacuvajBroj);
		nazad = (Button) findViewById(R.id.btnNazadPodesavanja);
		
		nazad.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {
			      finish();
			   }
			  });
		
		

		//if (savedInstanceState == null) {
		//	getSupportFragmentManager().beginTransaction()
		//			.add(R.id.container, new PlaceholderFragment()).commit();
	//	}
	}

	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.terapija1, menu);
		//return true;
	//}

	//@Override
	//public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		//int id = item.getItemId();
		//if (id == R.id.action_settings) {
		//	return true;
		//}
		//return super.onOptionsItemSelected(item);
	//}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	//public static class PlaceholderFragment extends Fragment {

		//public PlaceholderFragment() {
		//}

		//@Override
		//public View onCreateView(LayoutInflater inflater, ViewGroup container,
		//		Bundle savedInstanceState) {
		//	View rootView = inflater.inflate(R.layout.fragment_terapija1,
		//			container, false);
		//	return rootView;
	//	}
	//}
	
	private void initialize() {
		
		
		
		
		
	}

}
