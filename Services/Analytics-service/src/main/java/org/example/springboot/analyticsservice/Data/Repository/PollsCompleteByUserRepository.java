package org.example.springboot.analyticsservice.Data.Repository;

import org.example.springboot.analyticsservice.Data.Entity.PollsCompletedByUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollsCompleteByUserRepository extends JpaRepository<PollsCompletedByUser, Long> {
    boolean existsPollsCompletedByUserId(String userId);

    Optional<PollsCompletedByUser> findByUserId(String userId);
}
