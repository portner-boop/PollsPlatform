package org.example.springboot.pollsservice.Data.Repository;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.springboot.pollsservice.Data.Entities.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

    @Query("SELECT p FROM Poll p LEFT JOIN FETCH p.questions")
    List<Poll> findAllWithQuestions();

    List<Poll> findAll();

    Optional<Poll> findPollById(Long id);

    boolean existsByTitle(@NotNull @NotEmpty(message = "Fill this please") String title);
}
