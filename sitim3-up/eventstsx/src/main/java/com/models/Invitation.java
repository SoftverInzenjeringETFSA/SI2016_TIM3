package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ohrinator on 5/25/17.
 */
@Entity
public class Invitation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long eventID;
    private Long invited;

    private boolean responded;
    private boolean accepted;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEventID() { return eventID; }
    public void setEventID(Long eventID) { this.eventID = eventID; }

    public Long getInvited() { return invited; }
    public void setInvited(Long invited) { this.invited = invited; }

    public boolean isResponded() { return responded; }
    public void setResponded(boolean responded) { this.responded = responded; }

    public boolean isAccepted() { return accepted; }
    public void setAccepted(boolean accepted) { this.accepted = accepted; }
}
