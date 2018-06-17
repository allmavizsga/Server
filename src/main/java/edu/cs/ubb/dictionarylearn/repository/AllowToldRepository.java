package edu.cs.ubb.dictionarylearn.repository;

import edu.cs.ubb.dictionarylearn.model.AllowTold;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllowToldRepository extends CrudRepository<AllowTold,Long> {

    public AllowTold findByAllowToldId( Long allowToldId);
}