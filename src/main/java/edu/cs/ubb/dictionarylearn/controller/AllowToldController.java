package edu.cs.ubb.dictionarylearn.controller;

import edu.cs.ubb.dictionarylearn.model.AllowTold;
import edu.cs.ubb.dictionarylearn.service.AllowToldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allowtold")
public class AllowToldController {

    private AllowToldService service;

    @Autowired
    public AllowToldController(AllowToldService service) { this.service = service; }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AllowTold> getAllAllowTolds(){
        return this.service.findAll();
    }
}
