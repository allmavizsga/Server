package edu.cs.ubb.dictionarylearn.controller;

import edu.cs.ubb.dictionarylearn.model.AllowTold;
import edu.cs.ubb.dictionarylearn.model.Told;
import edu.cs.ubb.dictionarylearn.service.AllowToldService;
import edu.cs.ubb.dictionarylearn.service.ToldService;
import edu.cs.ubb.dictionarylearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/allowtold")
@CrossOrigin( origins = "http://localhost:3000")
public class AllowToldController {

    private AllowToldService service;
    private ToldService toldService;

    @Autowired
    public AllowToldController(AllowToldService service, ToldService toldService ) {
        this.service = service;
        this.toldService = toldService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AllowTold> getAllAllowTolds(){
        return this.service.findAll();
    }

    @RequestMapping(path = "/first", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AllowTold getFirstAllowTolds(){
        return this.service.findAll().iterator().next();
    }

    @RequestMapping(path = "/{allowToldId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllowTolds(@PathVariable Long allowToldId){
        this.service.deleteById(allowToldId);
    }

    @RequestMapping(path = "/{allowToldId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void acceptAllowTolds(@PathVariable Long allowToldId){
        AllowTold tempAllowTold = this.service.findByAllowToldId(allowToldId);
        Told told = new Told();
        told.setTold(tempAllowTold.getAllowTold());
        told.setWord(tempAllowTold.getWord());
        told.setToldId(0L);
        this.service.deleteById(allowToldId);
        System.out.println(this.toldService.findAllByTold(told.getTold()));
        if( this.toldService.findAllByTold(told.getTold()) != null) {

            this.toldService.save(told);
        }
    }
}
