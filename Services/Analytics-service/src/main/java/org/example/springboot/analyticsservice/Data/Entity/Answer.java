package org.example.springboot.analyticsservice.Data.Entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "answer", schema = "analytic")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "answer_id")
    private Long answerId;

    private String answer;

    private Boolean correctness;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "poll_id")
    private Poll poll;



}
