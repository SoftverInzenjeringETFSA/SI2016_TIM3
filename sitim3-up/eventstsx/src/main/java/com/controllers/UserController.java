package com.controllers;

import com.models.User;
//import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import com.repository.UserRepository;

import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ohrinator on 5/22/17.
 */
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping(path="/user")
public class UserController {
    // Kreirati repozitoriji za objekat
    // Koristiti Autowierd kako bi se automatski beans povezao
    @Autowired
    UserRepository userRepository;


    // Metoda za kreiranje novih korisnika u bazi
    // Potreno je odrediti requestparams koji se primaju i smještaju, bilo da su od POST ili GET requesta
    // Incijalizovati objekt koji uzimamo
    // repository.save(objekat)
    @RequestMapping(path="/create", method = RequestMethod.POST)
    public @ResponseBody boolean addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) throws NoSuchAlgorithmException {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();

        n.setName(name);
        n.setEmail(email);
        n.setRemoved(false);
        n.setReported(false);
        n.setRole("User");


        /* Generating password */
        String authPassword = password + email + "probamosecurity";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(authPassword.getBytes());
        byte[] digest = md.digest();
        String encodedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();

        n.setPassword(encodedPassword);


        /* Generate authenticaton token */
        String stringAuthToken = name + "eventsxt" + password + "eventstxt" + email;

        MessageDigest md2 = MessageDigest.getInstance("MD5");
        md.update(stringAuthToken.getBytes());
        byte[] digest2 = md2.digest();
        String authTokenCode = DatatypeConverter.printHexBinary(digest2).toUpperCase();

        n.setAuthToken(authTokenCode);

        if(userRepository.save(n) != null)
            return true;
        else
            return false;
    }

    /**************************************************************/

    @RequestMapping(path="/login", method = RequestMethod.POST, produces = "text/plain")
    public @ResponseBody String loginUser (@RequestParam String email, @RequestParam String password) throws NoSuchAlgorithmException {

        /* Generating password */
        String authPassword = password + email + "probamosecurity";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(authPassword.getBytes());
        byte[] digest = md.digest();
        String encodedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();

        Page<User> users = userRepository.findByMailAndPass(email, encodedPassword, new PageRequest(0, 1));

        if(users.getContent().size() > 0)
        {
            User loggedUser = users.getContent().get(0);
            return loggedUser.getAuthToken();
        }
        else return "0";
    }

    /**************************************************************/

    @RequestMapping(path="/checkToken", method = RequestMethod.POST)
    public @ResponseBody User checkToken (@RequestParam String token)  {
        User loggedUser = userRepository.findByToken(token);

        if(loggedUser == null)
            return null;
        else
            return loggedUser;
    }

    /**************************************************************/

    // Vrai jednog korisnika
    // Pošalji samo ID preko patha i to je to
    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public @ResponseBody User getSingleUser(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    /**************************************************************/

    // Vratisve korisnike
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**************************************************************/

    // Obriši korisnika sa posebni ID-em
    @RequestMapping(path="/delete/{id}", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity deleteSingleUser(@PathVariable Long id) {

        userRepository.delete(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**************************************************************/

    // Updateovanje informacija o korisniku
    @RequestMapping(path="/update", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity editUser (@RequestParam String name, @RequestParam String email){

        User n = new User();

        n.setName(name);
        n.setEmail(email);

        userRepository.save(n);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
