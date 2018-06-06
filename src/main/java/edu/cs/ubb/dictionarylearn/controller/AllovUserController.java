package edu.cs.ubb.dictionarylearn.controller;

import edu.cs.ubb.dictionarylearn.model.AllowUser;
import edu.cs.ubb.dictionarylearn.service.AllowUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allowuser")
public class AllovUserController {

    private AllowUserService service;

    @Autowired
    public AllovUserController(AllowUserService service){ this.service = service;  }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AllowUser> getAllAllowUsers(){
        return this.service.findAll();
    }
}
