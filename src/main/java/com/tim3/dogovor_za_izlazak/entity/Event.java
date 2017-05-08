package com.tim3.dogovor_za_izlazak.entity;

import java.util.Date;

public class Event {
	
	int event_id;
	int owner_id;
	Date voteDeadline;
	boolean reported;
	boolean removed;
	
	public Event(Date voteDeadline, boolean reported, boolean removed) {
		super();
		this.voteDeadline = voteDeadline;
		this.reported = reported;
		this.removed = removed;
	}

	public Date getVoteDeadline() {
		return voteDeadline;
	}

	public void setVoteDeadline(Date voteDeadline) {
		this.voteDeadline = voteDeadline;
	}

	public boolean isReported() {
		return reported;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
	
	

}
