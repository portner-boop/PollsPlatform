package org.example.springboot.analyticsservice.Data.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "poll", schema = "analytic")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_of_poll")
    private String typeOfPoll;

    @Column(name = "poll_id")
    private Long pollId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "polls_completed_by_user_id")
    private PollsCompletedByUser pollsCompletedByUser;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
        if (answers != null) answers.forEach(answer -> answer.setPoll(this));
    }



}
