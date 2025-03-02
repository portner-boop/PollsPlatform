package org.example.springboot.pollsservice.Data.Repository;


import org.example.springboot.pollsservice.Data.Entities.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    @Query("SELECT p FROM Poll p LEFT JOIN FETCH p.questions")
    List<Poll> findAllWithQuestions();
}
