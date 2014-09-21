package com.example.pois24;

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
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_podaci);
		final Animation animDugme = AnimationUtils.loadAnimation(this,
				R.anim.anim_alpha);

		btnPodaciRodj = (Button) findViewById(R.id.btnPodaciRodjendani);

		btnPodaciRodj.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.startAnimation(animDugme);
				mHandler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						Intent i1 = new Intent(
								"com.example.pois24.podaciRodj");
						startActivity(i1);
					}
				}, 260);
			}
		});
	}

}
