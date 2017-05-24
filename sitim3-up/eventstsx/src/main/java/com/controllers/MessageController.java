package com.controllers;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.models.Event;
import com.models.Message;
import com.models.User;
import com.repository.MessageRepository;
import com.repository.UserRepository;

@Controller
@RequestMapping(path="/message")
public class MessageController {

	 @Autowired
	    MessageRepository messageRepository;

	 @RequestMapping(path="/create", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity addNewMessage (@RequestParam String text, @RequestParam Integer u, @RequestParam Integer e) {
	        // @ResponseBody means the returned String is the response, not a view name
	        // @RequestParam means it is a parameter from the GET or POST request

	        Message m =new Message();
	        m.setText(text);
	        m.setUserID(u);
	        m.setEventID(e);
	        messageRepository.save(m);

	        return new ResponseEntity<>(null, HttpStatus.OK);
	    }
	 
	 @RequestMapping(path="/{id}", method = RequestMethod.GET)
	    public @ResponseBody Message getSingleMessage(@PathVariable Long id) {
	        return messageRepository.findOne(id);
	    }

	 @GetMapping(path="/all")
	    public @ResponseBody Iterable<Message> getAllMessages() {
	        return messageRepository.findAll();
	    }
	 
	 @RequestMapping(path="/delete/{id}", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity deleteSingleMessage(@PathVariable Long id) {

	        messageRepository.delete(id);

	        return new ResponseEntity<>(null, HttpStatus.OK);
	    }
}

