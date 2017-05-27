package com.repository;

import com.models.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.models.Message;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Long>, CrudRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.eventID = ?1 ORDER BY m.time DESC")
    List<Message> eventMessages(Long id);


}
