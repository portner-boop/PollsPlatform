package org.example.springboot.pollsservice.Data.Repository;

import org.example.springboot.pollsservice.Data.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.answers WHERE q.poll.id = :pollId")
    List<Question> findAllByPollIdWithAnswers(@Param("pollId") Long pollId);
}
