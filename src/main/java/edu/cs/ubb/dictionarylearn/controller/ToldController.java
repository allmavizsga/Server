package edu.cs.ubb.dictionarylearn.controller;

import edu.cs.ubb.dictionarylearn.model.Told;
import edu.cs.ubb.dictionarylearn.service.ToldService;
import edu.cs.ubb.dictionarylearn.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/told")
@CrossOrigin( origins = "http://localhost:3000")
public class ToldController {

    private ToldService service;
    private WordService wordService;

    @Autowired
    public ToldController(ToldService service, WordService wordService){
        this.service = service;
        this.wordService = wordService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Told> getAllTold(){
        return this.service.findAll();
    }

    @RequestMapping(path = "/{wordId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Told> getAllToldByWord(@PathVariable Long wordId){
        return this.service.findAllByWord( this.wordService.findByWordId(wordId));
    }

    @RequestMapping(path = "/{told}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Told getToldByTold(@PathVariable String told){
        return this.service.findAllByTold( told);
    }

    @RequestMapping(path = "/{told}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletToldByTold(@PathVariable String told){
        this.service.deleteByTold( told);
    }


}
