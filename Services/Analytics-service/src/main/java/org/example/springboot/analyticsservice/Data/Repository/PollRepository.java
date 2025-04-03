package org.example.springboot.analyticsservice.Data.Repository;

import org.example.springboot.analyticsservice.Data.Entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll,Long> {
    List<Poll> findAllById(Long pollId);
}
