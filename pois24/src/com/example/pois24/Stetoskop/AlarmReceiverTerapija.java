package com.example.pois24.Stetoskop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiverTerapija extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent intent) {
		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
		Toast.makeText(arg0, "sad je 45 minut!", Toast.LENGTH_LONG).show();
		
	}

}