package com.repository;

import com.models.Event;
import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends JpaRepository<Event, Long>, CrudRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.user = ?1")
    Iterable<Event> findByUser(Long id);
}