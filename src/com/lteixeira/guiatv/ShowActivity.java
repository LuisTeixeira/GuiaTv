package com.lteixeira.guiatv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends Activity {
	
	TextView title;
	TextView description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_description);
		title = (TextView) findViewById(R.id.showTitle);
		description = (TextView) findViewById(R.id.showDescription);
		Show show = ((GuiaTvApp)getApplication()).getShow();
		title.setText(show.getName());
		description.setText(show.getDescription());
	}
	
}
