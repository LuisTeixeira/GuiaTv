package com.lteixeira.guiatv;

import android.app.Application;

public class GuiaTvApp extends Application {
	
	//Debug Tag
	public final static String TAG = "GuiaTvApp";
	
	private Channel choice;
	private Show show;
	
	public Channel getChoice(){
		return choice;
	}
	
	public void setChoice(Channel choice){
		this.choice = choice;
	}
	
	public Show getShow(){
		return show;
	}
	
	public void setShow(Show show){
		this.show = show;
	}
}