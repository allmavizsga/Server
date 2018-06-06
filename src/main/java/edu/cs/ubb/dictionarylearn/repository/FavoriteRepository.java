package edu.cs.ubb.dictionarylearn.repository;


import edu.cs.ubb.dictionarylearn.model.Favorite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Long> {
    public Favorite findByFavoriteId(Long favoriteId);

}
