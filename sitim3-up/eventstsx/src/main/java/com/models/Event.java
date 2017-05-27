package com.models;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;
import javax.xml.soap.Text;

@Entity
public class Event {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

	private Long user;
	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	private String location;
	private Timestamp dateAndTime;

	private Timestamp voteDeadline;
	private Timestamp created_at;
	private boolean reported;
	private boolean removed;

	private String reportReason;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getVoteDeadline() {
		return voteDeadline;
	}
	public void setVoteDeadline(Timestamp voteDeadline) {
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

	public String getLocation() {return location; }
	public void setLocation(String location) { this.location = location; }

	public Timestamp getDateAndTime() { return dateAndTime; }
	public void setDateAndTime(Timestamp dateAndTime) { this.dateAndTime = dateAndTime; }

	public Long getUser() { return user; }
	public void setUser(Long user) { this.user = user; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public Timestamp getCreatedAt() { return created_at; }
	public void setCreatedAt(Timestamp createdAt) { this.created_at = createdAt; }

	public String getReportReason() { return reportReason; }
	public void setReportReason(String reportReason) { this.reportReason = reportReason; }
}
