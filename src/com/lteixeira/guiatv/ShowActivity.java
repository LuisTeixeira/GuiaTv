package com.lteixeira.guiatv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends Activity {
	
	TextView title;
	TextView description;
	TextView horaInicio;
	TextView horaFim;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_description);
		title = (TextView) findViewById(R.id.showTitle);
		description = (TextView) findViewById(R.id.showDescription);
		horaInicio = (TextView) findViewById(R.id.horaInicio);
		horaFim = (TextView) findViewById(R.id.horaFim);
		Show show = ((GuiaTvApp)getApplication()).getShow();
		setTitle(show.getName());
		title.setText(show.getName());
		description.setText(show.getDescription());
		horaInicio.setText(String.format("Inicio:\t %02d:%02d", show.getInicio().hour,show.getInicio().minute));
		horaFim.setText(String.format("Fim:\t %02d:%02d", show.getFim().hour,show.getFim().minute));
	}
	
}
