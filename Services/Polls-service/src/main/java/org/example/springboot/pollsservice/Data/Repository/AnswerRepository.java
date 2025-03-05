package org.example.springboot.pollsservice.Data.Repository;

import org.example.springboot.pollsservice.Data.Entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AnswerRepository  extends JpaRepository<Answer, Long> {
}
