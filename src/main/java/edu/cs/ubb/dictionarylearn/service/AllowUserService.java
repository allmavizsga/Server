package edu.cs.ubb.dictionarylearn.service;

import edu.cs.ubb.dictionarylearn.model.AllowUser;
import edu.cs.ubb.dictionarylearn.repository.AllowUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllowUserService {

    private AllowUserRepository repository;

    @Autowired
    public AllowUserService(AllowUserRepository repository) { this.repository = repository; }

    public Iterable<AllowUser> findAll(){
        return this.repository.findAll();
    }

    public AllowUser save(AllowUser usr){ return this.repository.save(usr); }

    public void deleteByEmail(String email){
        this.repository.deleteByEmail(email);
    }
    public void deleteById(Long id){
        this.repository.deleteById(id);
    }

    public Iterable<AllowUser> findByAllowUserEmail(String email){
        return this.repository.findByEmail(email);
    }
}
