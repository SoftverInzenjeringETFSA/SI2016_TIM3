package com.controllers;

import com.models.Event;
import com.sun.xml.internal.bind.v2.model.core.ID;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.repository.EventRepository;


@Controller
@RequestMapping(path="/event")
public class EventController {

	@Autowired
    EventRepository eventRepository;
	
	 @RequestMapping(path="/create", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity addNewEvent (@RequestParam Date voteDeadline) {
	        // @ResponseBody means the returned String is the response, not a view name
	        // @RequestParam means it is a parameter from the GET or POST request

		 	Event e = new Event();
		 	e.setVoteDeadline(voteDeadline);
		 	e.setReported(false);
		 	e.setRemoved(false);
	        eventRepository.save(e);

	        return new ResponseEntity<>(null, HttpStatus.OK);
	    }
	 
	   @RequestMapping(path="/{id}", method = RequestMethod.GET)
	    public @ResponseBody Event getSingleEvent(@PathVariable Long id) {
	        return eventRepository.findOne(id);
	    }
	   
	   @GetMapping(path="/all")
	    public @ResponseBody Iterable<Event> getAllEvents() {
	        return eventRepository.findAll();
	    }
	   
	   @RequestMapping(path="/delete/{id}", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity deleteSingleEvent(@PathVariable Long id) {

	        eventRepository.delete(id);

	        return new ResponseEntity<>(null, HttpStatus.OK);
	    }
	   
	   @RequestMapping(path="/update", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity editEvent (@RequestParam Date voteDeadline, @RequestParam boolean reported, @RequestParam boolean removed ){

	        Event e = new Event();
	        e.setVoteDeadline(voteDeadline);
	        e.setReported(reported);
	        e.setRemoved(removed);

	        eventRepository.save(e);

	        return new ResponseEntity<>(null, HttpStatus.OK);
	    }
	   

}


