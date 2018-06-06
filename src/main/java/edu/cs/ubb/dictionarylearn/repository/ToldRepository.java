package edu.cs.ubb.dictionarylearn.repository;

import edu.cs.ubb.dictionarylearn.model.Told;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToldRepository extends CrudRepository<Told, Long> {
    public Told findByToldId(Long toldId);

}
