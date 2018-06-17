package edu.cs.ubb.dictionarylearn.service;

import edu.cs.ubb.dictionarylearn.model.Word;
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

    public Word findByHungarianAndEnglish(String hungarian, String english) {
        return this.repository.findByHungarianAndEnglish(hungarian,english);
    }

    public Iterable<Word> findAllByHungarian(String hungarian) {
        return this.repository.findAllByHungarian(hungarian);
    }

    public Iterable<Word> findAllByEnglish(String english) {
        return this.repository.findAllByEnglish(english);
    }
}