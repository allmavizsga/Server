package edu.cs.ubb.dictionarylearn.repository;

import edu.cs.ubb.dictionarylearn.model.Told;
import edu.cs.ubb.dictionarylearn.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToldRepository extends JpaRepository<Told, Long> {
    public Told findByToldId(Long toldId);
    public Iterable<Told> findAllByWord(Word word);
    public  Told findByTold(String told);
    public void deleteByTold(String told);

//    @Modifying
//    @Query("INSERT into Told (told,word_id) VALUES(:told,:wordId)")
//    public void saveTold(@Param("told") String told,@Param("wordId") Long wordId);
}
