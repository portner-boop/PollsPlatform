package org.example.springboot.analyticsservice.Data.Repository;


import org.example.springboot.analyticsservice.Data.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {

    Long countAnswersByQuestionIdAndAnswer(Long questionId, String answer);
}
