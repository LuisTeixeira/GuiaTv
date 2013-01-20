package com.lteixeira.guiatv;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.Application;
import android.app.ListActivity;
import android.content.Context;
import android.util.Log;

public class GuiaTvApp extends Application {
	
	//Debug Tag
	public final static String TAG = "GuiaTvApp";
	
	private Channel choice;
	
	public Channel getChoice(){
		return choice;
	}
	
	public void setChoice(Channel choice){
		this.choice = choice;
	}
}