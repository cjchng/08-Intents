package com.course.example.intents;

import android.app.Activity; 
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LifeCycleTest extends Activity {

	Button btnFinish;
	TextView txtToDo, txtMsg;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lifecycle);

		txtToDo = (TextView) findViewById(R.id.txtToDo);
		txtMsg = (EditText) findViewById(R.id.txtMsg);

		String msg = "Instructions:                	                 \n "
				+ "0. New instance (onCreate, onStart, onResume)   \n "
				+ "1. Back Arrow   (onPause, onStop, onDestroy)    \n "
				+ "2. Finish       (onPause, onStop, onDestroy)    \n "
				+ "3. Home		 (onPause, onStop)	 \n "
				+ "4. After 3> App Tab> re-execute current app     \n "
				+ "  (onRestart, onStart, onResume)		 \n ";
				

		txtToDo.setText(msg);
		txtMsg.setHint("Enter some data here");

		btnFinish = (Button) findViewById(R.id.btnFinish);

		btnFinish.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		Toast.makeText(this, "onCreate - Test", Toast.LENGTH_LONG)
				.show();
	}//onCreate
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "onDestroy - Test", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onPause() {
		super.onPause();
		Toast.makeText(this, "onPause - Test", Toast.LENGTH_LONG)
				.show();

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this, "onRestart - Test", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "onResume - Test", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "onStart - Test", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(this, "onStop - Test", Toast.LENGTH_LONG)
				.show();
	}	
	
}//LifeCycleTest