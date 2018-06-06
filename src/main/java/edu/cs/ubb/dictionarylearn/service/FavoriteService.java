package edu.cs.ubb.dictionarylearn.service;

import edu.cs.ubb.dictionarylearn.model.Favorite;
import edu.cs.ubb.dictionarylearn.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    private FavoriteRepository repository;

    @Autowired
    public FavoriteService(FavoriteRepository repository){
        this.repository = repository;
    }

    public Iterable<Favorite> findAll(){
        return this.repository.findAll();
    }

    public Favorite save(Favorite favorite){
        return this.repository.save(favorite);
    }

    public void deleteById(Long favoriteId){
        this.repository.deleteById(favoriteId);
    }

}
