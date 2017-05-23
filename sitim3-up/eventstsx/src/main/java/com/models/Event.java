package com.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
	
	private Date voteDeadline;
	private boolean reported;
	private boolean removed;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
