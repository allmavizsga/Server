package edu.cs.ubb.dictionarylearn.controller;

import edu.cs.ubb.dictionarylearn.model.User;
import edu.cs.ubb.dictionarylearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getAllUsers(){
        return this.service.findAll();
    }

    @RequestMapping(path = "/{email}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User findByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        return this.service.findByEmailAndPassword(email, password);
    }

    @RequestMapping(path = "/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User findByIdEmail(@PathVariable String email){
        return this.service.findByEmail(email);
    }

    @RequestMapping(path = "/{user}",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public  User save(@PathVariable String user) {
        User user1 = new User();
        user1.setAddress("dsad");
        user1.setAdmin(false);
        user1.setEmail("asdsa@sad");
        user1.setPassword("sad");
        user1.setState("sd");
        user1.setTown("sad");
        return this.service.save(user1);}
}

