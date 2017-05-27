package com.controllers;

import com.models.Event;
import com.models.Invitation;
import com.models.User;
import com.repository.EventRepository;
import com.repository.InvitationRepository;
import com.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ohrinator on 5/25/17.
 */
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping(path="/invitation")
public class InvitationController {

    @Autowired
    InvitationRepository invitationRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    /* Send invitation */
    @RequestMapping(path="/create", method = RequestMethod.POST)
    public @ResponseBody
    boolean addNewEvent (@RequestParam Long eventID, @RequestParam Long invited) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        if(!invitationRepository.doesItExists(eventID, invited))
        {
            Invitation i = new Invitation();

            i.setEventID(eventID);
            i.setInvited(invited);
            i.setResponded(false);
            i.setAccepted(false);

            invitationRepository.save(i);

            return true;
        }else return false;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Invitation> getAllUsers() {
        return invitationRepository.findAll();
    }

    /* Responde to invitation */
    @RequestMapping(path="/responde", method = RequestMethod.POST)
    public @ResponseBody
    boolean espondeToInvitation (@RequestParam Long invitationID, @RequestParam boolean response) {
        Invitation inv = invitationRepository.findOne(invitationID);

        inv.setAccepted(response);
        inv.setResponded(true);

        invitationRepository.save(inv);

        return true;
    }

    /* Not responded yet */
    @RequestMapping(path="/notResponded", method = RequestMethod.POST)
    public @ResponseBody
    String notResponded (@RequestParam Long user) {
        List<Invitation> invs = invitationRepository.notRespondedUser(user);

        JSONArray array = new JSONArray();

        for(Invitation invitation : invs) {
            JSONObject item = new JSONObject();

            Event e = eventRepository.findOne(invitation.getEventID());

            try{
                item.put("invitationID", invitation.getId().toString());
                item.put("eventName", e.getName());
                item.put("voteDeadline", e.getVoteDeadline().toString());
            }catch(Exception ex){
                return invitation.getEventID().toString();
            }

            array.put(item);
        }

        return array.toString();
    }

    /* Accepted events */
    @RequestMapping(path="/myEvents", method = RequestMethod.POST)
    public @ResponseBody
    String acceptedEvents (@RequestParam Long user) {
        List<Invitation> invs = invitationRepository.acceptedEvents(user);

        JSONArray array = new JSONArray();

        for(Invitation invitation : invs) {
            JSONObject item = new JSONObject();

            Event e = eventRepository.findOne(invitation.getEventID());

            try{
                item.put("id", e.getId());
                item.put("location", e.getLocation());
                item.put("name", e.getName());
                item.put("dateAndTime", e.getDateAndTime().toString());
            }catch(Exception ex){
                return invitation.getEventID().toString();
            }

            array.put(item);
        }

        return array.toString();
    }

    /* Invited users */
    @RequestMapping(path="/event", method = RequestMethod.POST)
    public @ResponseBody
    String eventUsers (@RequestParam Long eventID) {
        List<Invitation> invs = invitationRepository.findByEvent(eventID);

        JSONArray array = new JSONArray();

        for(Invitation invitation : invs) {
            JSONObject item = new JSONObject();

            User u = userRepository.findOne(invitation.getInvited());

            try{
                item.put("id", u.getId());
                item.put("name", u.getName());
                item.put("responded", invitation.isResponded());
                item.put("accepted", invitation.isAccepted());
                item.put("invitationID", invitation.getId());
            }catch(Exception ex){
                return invitation.getEventID().toString();
            }

            array.put(item);
        }

        return array.toString();
    }

    /* Cancle ivnitation */
    @RequestMapping(path="/remove", method = RequestMethod.POST)
    public @ResponseBody
    boolean cancleInvitation (@RequestParam Long invitationID, @RequestParam Long userID) {
        if (invitationRepository.checkInvitation(invitationID, userID)) {
            invitationRepository.delete(invitationID);
            return true;
        }else return false;

    }
}
