package com.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private Long id;
	 
	 private String text;
	 private Timestamp time;
	 private Long userID;
	 private Long eventID;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long user) {
		this.userID = user;
	}

	public Long getEventID() {
		return eventID;
	}
	public void setEventID(Long event) {
		this.eventID = event;
	}

}
