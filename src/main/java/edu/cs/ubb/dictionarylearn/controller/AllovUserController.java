package edu.cs.ubb.dictionarylearn.controller;

import edu.cs.ubb.dictionarylearn.model.AllowUser;
import edu.cs.ubb.dictionarylearn.model.User;
import edu.cs.ubb.dictionarylearn.service.AllowUserService;
import edu.cs.ubb.dictionarylearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allowuser")
@CrossOrigin( origins = "http://localhost:3000")
public class AllovUserController {

    private AllowUserService service;
    private UserService userService;

    @Autowired
    public AllovUserController(AllowUserService service, UserService userService){
        this.service = service;
        this.userService = userService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AllowUser> getAllAllowUsers(){
        return this.service.findAll();
    }

    @RequestMapping(path = "/first", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AllowUser getFirstAllowUser(){
        Iterable<AllowUser> allowUser = this.service.findAll();
        if(allowUser.iterator().hasNext()){
            return allowUser.iterator().next();
        }
        return new AllowUser();
    }

    @RequestMapping(path = "/{allowUserEmail}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllowUserEmail(@PathVariable String allowUserEmail){
        this.service.deleteByEmail(allowUserEmail);
    }

    @RequestMapping(path = "/{allowUserEmail}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void acceptAllowUser(@PathVariable String allowUserEmail){
        if( this.userService.findByEmail(allowUserEmail) == null )
        {

            AllowUser allowUser = this.service.findByAllowUserEmail(allowUserEmail).iterator().next();
            User user = new User();
            user.setAddress(allowUser.getAddress());
            user.setAdmin(allowUser.getAdmin());
            user.setEmail(allowUser.getEmail());
            user.setPassword(allowUser.getPassword());
            user.setState(allowUser.getState());
            user.setTown(allowUser.getTown());
            this.userService.save(user);

            System.out.println("itt");
        }
        this.service.deleteByEmail(allowUserEmail);
    }

    @RequestMapping(path = "/new/{allowUserEmail}/{allowUserPassword}/{allowUserAddress}/{allowUserTown}/{allowUserState}/{allowUserAdmin}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AllowUser saveAllowUser(@PathVariable String allowUserEmail, @PathVariable String allowUserPassword, @PathVariable String allowUserAddress, @PathVariable String allowUserTown, @PathVariable String allowUserState, @PathVariable Boolean allowUserAdmin){
        AllowUser allowUser = new AllowUser();
        allowUser.setEmail(allowUserEmail);
        allowUser.setPassword(allowUserPassword);
        allowUser.setAddress(allowUserAddress);
        allowUser.setTown(allowUserTown);
        allowUser.setState(allowUserState);
        allowUser.setAdmin(allowUserAdmin);
        System.out.println(allowUser.getEmail());
        return this.service.save(allowUser);
    }

}
