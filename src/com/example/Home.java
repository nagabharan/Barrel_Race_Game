/*
	This program will display the main menu of the Barrel Race Game. There are 3 options on this screen - Start game,
	settings and highscores.
	
	Name: Nagabharan Nagendran
	Net ID: nxn141730
	Date Created: 11-26-2014
	Purpose: Assignment
	Class: CS6301.022 User Interface Design
 */
package com.example;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends Activity implements OnClickListener {

	private Button startBtn;
	private Button highscore;
	private Button settingsBtn;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Coloring the action bar according to material design standards
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#BF360C")));

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		startBtn = (Button) findViewById(R.id.start);

		startBtn.setOnClickListener(this);

		highscore = (Button) findViewById(R.id.highscore);
		highscore.setOnClickListener(this);

		settingsBtn = (Button) findViewById(R.id.setting);
		settingsBtn.setOnClickListener(this);

	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			startActivity(new Intent(Home.this, BarrelRaceActivity.class));

			break;

		case R.id.highscore:

			Intent highIntent = new Intent(this, HighScoreActivity.class);
			this.startActivity(highIntent);

			break;

		case R.id.setting:

			startActivity(new Intent(Home.this, SettingsActivity.class));
		}
	}

	//End the game
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
		return;
	}

	//Kill the process on completion
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		android.os.Process.killProcess(android.os.Process.myPid());
		super.onDestroy();
	}

}
