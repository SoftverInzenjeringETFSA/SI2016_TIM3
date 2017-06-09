package com.controllers;

import com.models.Event;
import com.models.Invitation;
import com.repository.InvitationRepository;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.repository.EventRepository;

import javax.xml.soap.Text;


@Controller
@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping(path="/event")
public class EventController {

	@Autowired
    EventRepository eventRepository;

	@Autowired
	InvitationRepository invitationRepository;
	
	 @RequestMapping(path="/create", method = RequestMethod.POST)
	    public @ResponseBody Long addNewEvent (@RequestParam Long voteDeadline, @RequestParam String name, @RequestParam String description, @RequestParam String location, @RequestParam Long dateAndTime, @RequestParam Long user) {
	        // @ResponseBody means the returned String is the response, not a view name
	        // @RequestParam means it is a parameter from the GET or POST request

		 	Event e = new Event();

		 	e.setVoteDeadline(new Timestamp(voteDeadline));
		 	e.setDateAndTime(new Timestamp(dateAndTime));

		 	e.setName(name);
		 	e.setDescription(description);
		 	e.setLocation(location);
		 	e.setReported(false);
		 	e.setRemoved(false);
		 	e.setUser(user);
		 	e.setCreatedAt(new Timestamp(System.currentTimeMillis()));

	        Event ev = eventRepository.save(e);

		 	/* Automaticlly make invitation for htis user */
		 	Invitation invitation = new Invitation();
		 	invitation.setEventID(ev.getId());
		 	invitation.setResponded(true);
		 	invitation.setAccepted(true);
		 	invitation.setInvited(user);

		 	invitationRepository.save(invitation);

	        return ev.getId();
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
	    public @ResponseBody boolean deleteSingleEvent(@PathVariable Long id) {

		   	invitationRepository.deleteEventInvitations(id);
	        eventRepository.delete(id);

	        return true;
	    }

	    /* Izlistaj sve evente jednog korisnika */
	    @RequestMapping(path="/user/{id}", method = RequestMethod.POST)
		public @ResponseBody Iterable<Event> getMyEvents(@PathVariable Long id) {
			return eventRepository.findByUser(id);
		}

		/* Report event */
		@RequestMapping(path="/report", method = RequestMethod.POST)
		public @ResponseBody
		boolean reportEvent(@RequestParam Long eventID, @RequestParam Long userID, @RequestParam String reason)
		{
			if(invitationRepository.doesItExists(eventID, userID))
			{
				Event e = eventRepository.findOne(eventID);

				e.setReported(true);
				e.setReportReason(reason);

				eventRepository.save(e);

				return true;
			}else return false;
		}
	   
	   /*@RequestMapping(path="/update", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity editEvent (@RequestParam Date voteDeadline, @RequestParam boolean reported, @RequestParam boolean removed ){

	        Event e = new Event();
	        e.setVoteDeadline(voteDeadline);
	        e.setReported(reported);
	        e.setRemoved(removed);

	        eventRepository.save(e);

	        return new ResponseEntity<>(null, HttpStatus.OK);
	    }*/
	   

}


