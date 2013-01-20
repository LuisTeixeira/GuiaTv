package com.lteixeira.guiatv;

import java.util.List;

import android.app.Application;

public class GuiaTvApp extends Application {
	
	//Debug Tag
	public final static String TAG = "GuiaTvApp";
	
	private Channel choice;
	private Channel last;
	List<Channel> channels;
	private Show show;
	List<Show> shows;
	
	public Channel getLast() {
		return last;
	}

	public void setLast(Channel last) {
		this.last = last;
	}
	
	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

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