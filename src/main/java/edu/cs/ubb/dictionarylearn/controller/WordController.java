package edu.cs.ubb.dictionarylearn.controller;

import edu.cs.ubb.dictionarylearn.model.Word;
import edu.cs.ubb.dictionarylearn.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/word")
@CrossOrigin( origins = "http://localhost:3000")
public class WordController {

    private WordService service;

    @Autowired
    public WordController(WordService service){
        this.service = service;
    }

    @RequestMapping(path = "/{wordId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Word findByWordId(@PathVariable Long wordId){
        return this.service.findByWordId(wordId);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Word> getAllWord(){
        return this.service.findAll();
    }

    @RequestMapping(path = "/{hungarian}/{english}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Word findByHungarianAndEnglish(@PathVariable String hungarian, @PathVariable String english){
        return this.service.findByHungarianAndEnglish(hungarian, english);
    }

    @RequestMapping(path = "/hu/{hungarian}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Word> findAllByHungarian(@PathVariable String hungarian){
        return this.service.findAllByHungarian(hungarian);
    }

    @RequestMapping(path = "/en/{english}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Word> findAllByEnglish(@PathVariable String english){
        return this.service.findAllByEnglish( english);
    }



}
