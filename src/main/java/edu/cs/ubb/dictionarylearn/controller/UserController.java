package edu.cs.ubb.dictionarylearn.controller;

import edu.cs.ubb.dictionarylearn.model.User;
import edu.cs.ubb.dictionarylearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        User user = this.service.findByEmail(email);
        if( user != null)
            return user;
        return new User();
    }

    @RequestMapping(path = "/{email}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteByIdEmail(@PathVariable String email){
         this.service.deleteByEmail(email);
    }

    @RequestMapping(path = "/newuser",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public  User save(@RequestBody User user) {
        if (service.findByEmail(user.getEmail()) == null) {
            User myuser = new User();
            myuser.setAddress(user.getAddress());
            myuser.setAdmin(user.getAdmin());
            myuser.setEmail(user.getEmail());
            myuser.setPassword(user.getPassword());
            myuser.setState(user.getState());
            myuser.setTown(user.getTown());
            return this.service.save(myuser);
        }

        return  new User();
    }
}

