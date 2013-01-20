package com.lteixeira.guiatv;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;

public class Schedule extends ListActivity {
	//Debug Tag
	public final static String TAG = "Schedulde";
	
	//Request Constants
	public final static String STARTHOUR = "06:00:00";
	public final static String ENDHOUR = "05:00:00";
	public final static String SIGLA = "channelSigla";
	public final static String START_TIME = "startDate";
	public final static String END_TIME = "endDate";
	public final static long MILISECONDS_IN_DAY = 86400000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Channel channel = ((GuiaTvApp)getApplicationContext()).getChoice();
		Time today = new Time();
		today.setToNow();
		setTitle(channel.getName());
		try{
			URL url = prepareUrl(channel, today);
			Log.d(TAG, url.toString());
			RequestScheduleTask task = new RequestScheduleTask(this);
			task.execute(url);
		}catch(MalformedURLException ex){
			Log.d(TAG,"MalformedURLException");
		}
		Log.d(TAG, channel.toString());
	}
	
	
	private URL prepareUrl(Channel channel, Time date) throws MalformedURLException{
		Time endTime = new Time();
		if(date.hour < 6)
			date.set(date.toMillis(true) - MILISECONDS_IN_DAY);
		String[] startDate = {Integer.toString(date.year),Integer.toString(date.month+1),Integer.toString(date.monthDay)};
		endTime.set(date.toMillis(true) + MILISECONDS_IN_DAY);
		String[] endDate = {Integer.toString(endTime.year),Integer.toString(endTime.month+1),Integer.toString(endTime.monthDay)};
		
		StringBuffer request = new StringBuffer();
		
		request.append("http://services.sapo.pt/EPG/GetChannelByDateInterval?");
		request.append(SIGLA + "=" + channel.getSigla());
		request.append("&" + START_TIME + "=" + startDate[0] + "-" + startDate[1] + "-" + startDate[2] + "%20" + STARTHOUR);
		request.append("&" + END_TIME + "=" + endDate[0] + "-" + endDate[1] + "-" + endDate[2] + "%20" + ENDHOUR);
		return new URL(request.toString());
	}
}
