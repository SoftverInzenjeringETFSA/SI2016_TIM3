package com.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
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

import java.sql.Timestamp;
import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping(path="/message")
public class MessageController {

	 @Autowired
	 MessageRepository messageRepository;

	 @Autowired
	 UserRepository userRepository;

	 @RequestMapping(path="/create", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity addNewMessage (@RequestParam String text, @RequestParam Long u, @RequestParam Long e) {
	        // @ResponseBody means the returned String is the response, not a view name
	        // @RequestParam means it is a parameter from the GET or POST request

	        Message m =new Message();
	        m.setText(text);
	        m.setUserID(u);
	        m.setEventID(e);
	        m.setTime(new Timestamp(System.currentTimeMillis()));
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

	 @RequestMapping(path="event", method = RequestMethod.POST)
		public @ResponseBody String getEventMessages(@RequestParam Long eventID){

		 List<Message> messages = messageRepository.eventMessages(eventID);

		 JSONArray array = new JSONArray();

		 for(Message msg : messages) {
			 JSONObject item = new JSONObject();

			 User u = userRepository.findOne(msg.getUserID());

			 try{
				 item.put("id", msg.getId());
				 item.put("name", u.getName());
				 item.put("text", msg.getText());
				 item.put("time", msg.getTime());
			 }catch(Exception ex){
				 return msg.getEventID().toString();
			 }

			 array.put(item);
		 }

		 return array.toString();

	 }

	 /*@RequestMapping(path="/delete/{id}", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity deleteSingleMessage(@PathVariable Long id) {

	        messageRepository.delete(id);

	        return new ResponseEntity<>(null, HttpStatus.OK);
	    }*/
}

