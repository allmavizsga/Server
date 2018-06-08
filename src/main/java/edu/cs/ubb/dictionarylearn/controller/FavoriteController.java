package edu.cs.ubb.dictionarylearn.controller;

import edu.cs.ubb.dictionarylearn.model.Favorite;
import edu.cs.ubb.dictionarylearn.service.FavoriteService;
import edu.cs.ubb.dictionarylearn.service.UserService;
import edu.cs.ubb.dictionarylearn.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/favorite")
@CrossOrigin ( origins = "http://localhost:3000")
public class FavoriteController {

    private FavoriteService service;
    private UserService userService;
    private WordService wordService;

    @Autowired
    public FavoriteController(FavoriteService service, UserService userService, WordService wordService){
            this.service = service;
            this.userService = userService;
            this.wordService = wordService;
        }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Favorite> getAllFavorite(){
            return this.service.findAll();
        }


    @RequestMapping(path = "/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Favorite> findByEmail(@PathVariable String email){
        return this.service.findByUser( this.userService.findByEmail(email));
    }

    @RequestMapping(path = "/{email}/{wordId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Favorite findByEmailAndWordId(@PathVariable String email, @PathVariable Long wordId){
        return this.service.findByUserAndWord( this.userService.findByEmail(email), this.wordService.findByWordId(wordId));
    }

    @RequestMapping(path = "/{email}/{wordId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@PathVariable String email, @PathVariable Long wordId){
        Favorite favorite = new Favorite();
        favorite.setUser( this.userService.findByEmail(email) );
        favorite.setWord(  this.wordService.findByWordId(wordId) );
        favorite.setFavoriteId( 0L );
        this.service.save( favorite );
    }

    @RequestMapping(path = "/{email}/{wordId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String email, @PathVariable Long wordId){
        this.service.deleteById( this.service.findByUserAndWord( this.userService.findByEmail(email), this.wordService.findByWordId(wordId)).getfavoriteId() );
    }

}
