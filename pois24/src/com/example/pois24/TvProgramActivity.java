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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.os.Build;

public class TvProgramActivity extends ActionBarActivity {
	
	TextView naslov, naziv, datum, vreme;
	EditText unos;
	Button nazad, sacuvaj;
	DatePicker datumP;
	TimePicker vremeP;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tv_program);
		
		naslov = (TextView) findViewById(R.id.txtTVNaslov);
		naziv = (TextView) findViewById(R.id.txtTVIme);
		unos = (EditText) findViewById(R.id.edtTVUnos);
		datum  = (TextView) findViewById(R.id.txtTVDatum);
		datumP  = (DatePicker) findViewById(R.id.dpDatum);
		vreme = (TextView) findViewById(R.id.txtTVVreme);
		vremeP = (TimePicker) findViewById(R.id.tpVreme);
		sacuvaj = (Button)  findViewById(R.id.btnSacuvajBroj);
		nazad = (Button) findViewById(R.id.btnNazadRodjendan);
		
		nazad.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {
			      finish();
			   }
			  });

		//if (savedInstanceState == null) {
			//getSupportFragmentManager().beginTransaction()
				//	.add(R.id.container, new PlaceholderFragment()).commit();
		//}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tv_program, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	//public static class PlaceholderFragment extends Fragment {

		//public PlaceholderFragment() {
		//}

		//@Override
		//public View onCreateView(LayoutInflater inflater, ViewGroup container,
			//	Bundle savedInstanceState) {
			//View rootView = inflater.inflate(R.layout.fragment_tv_program,
				//	container, false);
			//return rootView;
		//}
	//}

}
