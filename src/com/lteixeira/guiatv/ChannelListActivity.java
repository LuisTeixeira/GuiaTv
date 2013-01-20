package com.lteixeira.guiatv;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class ChannelListActivity extends ListActivity {

	//Debug Tag
	public final static String TAG = "ChannelListActivity";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(((GuiaTvApp)getApplication()).getChannels() == null)
			updateChannels();
		else
			setListAdapter(new ChannelsAdapter(this, R.layout.list_row, ((GuiaTvApp)getApplication()).getChannels()));
		Log.d(TAG,"CREATED");
	}

	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent scheduleIntent = new Intent(this,Schedule.class);
		Channel channel = (Channel) l.getItemAtPosition(position);
		((GuiaTvApp)getApplication()).setChoice(channel);
		startActivity(scheduleIntent);
		Log.d(TAG, channel.toString());
 	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_channel_list, menu);
		return true;
	}
	
	public void updateChannels(){
		try {
			URL url = new URL("http://services.sapo.pt/EPG/GetChannelList");
			RequestChannelsTask request = new RequestChannelsTask(this);
			request.execute(url);
		} catch (MalformedURLException e) {
		}	
	}

}
