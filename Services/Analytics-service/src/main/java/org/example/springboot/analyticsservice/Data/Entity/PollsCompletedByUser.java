package org.example.springboot.analyticsservice.Data.Entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "polls_completed_by_user", schema = "analytic")
public class PollsCompletedByUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String userId;

    @OneToMany(mappedBy = "pollsCompletedByUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Poll> polls;

    public void addPoll(Poll poll) {

        polls.add(poll);
        if(polls != null)  poll.setPollsCompletedByUser(this);
    }

}
