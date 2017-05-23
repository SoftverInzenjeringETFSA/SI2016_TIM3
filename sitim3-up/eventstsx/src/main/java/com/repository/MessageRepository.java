package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.models.Message;

	
public interface MessageRepository extends JpaRepository<Message, Long>, CrudRepository<Message, Long> {

	

}
