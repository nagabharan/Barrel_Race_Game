/*
	This program will display the time taken by the user to win/lose, the highscore and option to replay or go back to main screen.
	If the user has won his name will be promtped for putting it into the highscores list.
	
	Name: Nagabharan Nagendran
	Net ID: nxn141730
	Date Created: 11-26-2014
	Purpose: Assignment
	Class: CS6301.022 User Interface Design
 */

package com.example;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FinalActivity extends Activity implements OnClickListener {

	private Button replay;
	private Button home;

	private EditText name;
	private Button save;
	private TextView pname;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_final);

		name = (EditText) findViewById(R.id.name);
		save = (Button) findViewById(R.id.save);
		pname = (TextView) findViewById(R.id.promptname);

		name.setVisibility(View.INVISIBLE);
		pname.setVisibility(View.INVISIBLE);
		save.setVisibility(View.INVISIBLE);

		Bundle b = getIntent().getExtras();
		System.out.println(b.getString("win"));

		replay = (Button) findViewById(R.id.replay);
		replay.setOnClickListener(this);

		home = (Button) findViewById(R.id.mainmenu);
		home.setOnClickListener(this);

		Bundle e = getIntent().getExtras();

		TextView tim = (TextView) findViewById(R.id.scoreTextView);
		tim.setText(e.getString("time"));

		TextView res = (TextView) findViewById(R.id.result);
		res.setText(e.getString("win"));

		TextView highScore = (TextView) findViewById(R.id.highTextView);

		SharedPreferences highPref = getSharedPreferences("findhighscore", 0);
		String s = highPref.getString("highscore", "NO SCORE AVAILABLE");
		highScore.setText(s);

		if (b.getString("win").equalsIgnoreCase("You Won!")) {

			pname.setVisibility(View.INVISIBLE);
			name.setVisibility(View.VISIBLE);
			save.setVisibility(View.VISIBLE);

			save.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (name.getText().equals("")) {
						Toast.makeText(getApplicationContext(),
								"Please enter your name", Toast.LENGTH_SHORT)
								.show();
					} else {
						SharedPreferences high = getSharedPreferences(
								"findhighscore", 0);
						SharedPreferences.Editor scoreEdit = high.edit();

						String score = high.getString("highScores", "");
						String time = (String) getIntent().getExtras().get(
								"time");

						StringBuilder str = new StringBuilder(score);
						str.append(name.getText().toString());
						str.append("-");
						str.append(time);
						str.append("|");

						scoreEdit.putString("highScores", str.toString());
						scoreEdit.commit();

						Toast.makeText(getApplicationContext(),
								"Saved:" + str.toString(), Toast.LENGTH_SHORT)
								.show();

						startActivity(new Intent(FinalActivity.this, Home.class));

					}
				}
			});
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.replay:
			startActivity(new Intent(FinalActivity.this,
					BarrelRaceActivity.class));
			finish();
			break;

		case R.id.mainmenu:
			startActivity(new Intent(FinalActivity.this, Home.class));
			break;

		}

	}

	@Override
	public void onBackPressed() {
		finish();
		return;
	}
}
