package edu.cs.ubb.dictionarylearn.repository;

import edu.cs.ubb.dictionarylearn.model.AllowUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllowUserRepository extends JpaRepository<AllowUser, Long> {

    public AllowUser findByAllowUserEmail(String email);
    public Iterable<AllowUser> findByEmail(String email);
    public void deleteByEmail(String email);
}
