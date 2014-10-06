package com.example.pois24.Sat;

import com.example.pois24.R;
import com.example.pois24.R.anim;
import com.example.pois24.R.id;
import com.example.pois24.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class PodaciActivity extends ActionBarActivity {

	Button btnPodaciRodj;
	Button btnPodaciTV;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_1podaci);
		final Animation animDugme = AnimationUtils.loadAnimation(this,
				R.anim.anim_alpha);
		initialize();

		btnPodaciRodj.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						Intent i1 = new Intent("com.example.pois24.podaciRodj");
						startActivity(i1);
					}
				}, 260);
			}
		});

		btnPodaciTV.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						Intent i1 = new Intent("com.example.pois24.podaciTV");
						startActivity(i1);
					}
				}, 260);
			}
		});
	}

	public void initialize() {
		btnPodaciRodj = (Button) findViewById(R.id.btnPodaciRodjendani);
		btnPodaciTV = (Button) findViewById(R.id.btnPodaciTVprogram);
	}

}
