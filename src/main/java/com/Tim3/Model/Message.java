package com.Tim3.Model;

import java.util.Date;

public class Message {
	
	int event_id;
	int owner_id;
	String text;
	Date time;
	
	public Message(String text, Date time) {
		super();
		this.text = text;
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
