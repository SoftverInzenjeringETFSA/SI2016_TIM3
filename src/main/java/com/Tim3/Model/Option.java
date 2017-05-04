package com.Tim3.Model;

public class Option {
	
	int option_id;
	int detail_id;
	String text;
	
	public Option(String txt) {
		this.text = txt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
