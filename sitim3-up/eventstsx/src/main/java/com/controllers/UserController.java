package com.controllers;

import com.models.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.repository.UserRepository;

/**
 * Created by ohrinator on 5/22/17.
 */
@Controller
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
    public @ResponseBody ResponseEntity addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();

        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);

        n.setRemoved(false);
        n.setReported(false);
        n.setRole("User");

        userRepository.save(n);

        return new ResponseEntity<>(null, HttpStatus.OK);
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
