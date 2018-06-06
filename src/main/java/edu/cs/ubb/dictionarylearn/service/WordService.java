package edu.cs.ubb.dictionarylearn.service;

import edu.cs.ubb.dictionarylearn.model.User;
import edu.cs.ubb.dictionarylearn.model.Word;
import edu.cs.ubb.dictionarylearn.repository.UserRepository;
import edu.cs.ubb.dictionarylearn.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    private WordRepository repository;

    @Autowired
    public WordService(WordRepository repository){
        this.repository = repository;
    }

    public Iterable<Word> findAll(){
        return this.repository.findAll();
    }

    public Word findByWordId(Long wordId) { return this.repository.findByWordId(wordId); }
}
