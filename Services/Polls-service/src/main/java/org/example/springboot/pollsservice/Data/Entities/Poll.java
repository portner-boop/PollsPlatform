package org.example.springboot.pollsservice.Data.Entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "polls")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @CreationTimestamp
    private LocalDateTime dateOfCreation;

    @Enumerated(EnumType.STRING)
    TypeOfPoll typeOfPoll;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        if (questions != null) questions.forEach(q -> q.setPoll(this));
    }


}
