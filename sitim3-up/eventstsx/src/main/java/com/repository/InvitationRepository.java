package com.repository;

import com.models.Invitation;
import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ohrinator on 5/25/17.
 */
public interface InvitationRepository extends JpaRepository<Invitation, Long>, CrudRepository<Invitation, Long> {

    /* Get all invitations for event */
    @Query("SELECT i FROM Invitation i WHERE i.eventID = ?1")
    List<Invitation> findByEvent(Long id);

    /* Check if invitation exists */
    @Query("SELECT count(i) > 0 FROM Invitation i WHERE i.eventID = ?1 AND i.invited = ?2")
    boolean doesItExists(Long eventID, Long userID);

    /* Not responded events for  user */
    @Query("SELECT i FROM Invitation i WHERE i.invited = ?1 AND i.responded = false")
    List<Invitation> notRespondedUser(Long id);

    /* Accepted events */
    @Query("SELECT i FROM Invitation i WHERE i.invited = ?1 AND i.responded = true AND i.accepted = true")
    List<Invitation> acceptedEvents(Long id);

    /* Remove invitation */
    @Query("SELECT count(i) > 0 FROM Invitation i WHERE i.id = ?1 AND i.invited = ?2")
    boolean checkInvitation(Long invitation, Long user);

}
