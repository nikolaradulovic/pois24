package com.example.pois24;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SatActivity extends ActionBarActivity {

	TextView naslov, prazan;
	Button tv, rodjendani, pregledi, nazad, uneto;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_sat);
		
		naslov = (TextView) findViewById(R.id.sat_naslov);
		prazan = (TextView) findViewById(R.id.prazan);
		rodjendani = (Button) findViewById(R.id.btnRodjendani);
		tv = (Button) findViewById(R.id.btnTvProgram);
		pregledi = (Button) findViewById(R.id.btnPregledi);
		uneto = (Button) findViewById(R.id.btnUneto);
		nazad = (Button) findViewById(R.id.btnNazad);
		
		
		nazad.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {
			      finish();
			   }
			  });
		
		rodjendani.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {
				   Intent openRodjendanActivity = new Intent(
						"com.example.pois24.RODJENDAN");
					startActivity(openRodjendanActivity);
			   }
			  });
		
		tv.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {
				   Intent openTvProgramActivity = new Intent(
						"com.example.pois24.TVPROGRAM");
					startActivity(openTvProgramActivity);
			   }
			  });
		
		pregledi.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {
				   Intent openPreglediActivity = new Intent(
						"com.example.pois24.PREGLEDI");
					startActivity(openPreglediActivity);
			   }
			  });
			  
	//	if (savedInstanceState == null) {
		//	getSupportFragmentManager().beginTransaction()
			//		.add(R.id.btnBackTerapije, new PlaceholderFragment()).commit();
		//}
	//}

	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.sat, menu);
		//return true;
	//}

	//@Override
	//public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		//int id = item.getItemId();
		//if (id == R.id.action_settings) {
			//return true;
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
			//	Bundle savedInstanceState) {
			//View rootView = inflater.inflate(R.layout.fragment_sat, container,
				//	false);
			//return rootView;
		//}
	}

}
