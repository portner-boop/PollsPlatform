package org.example.springboot.analyticsservice.Api.Mapper;

import lombok.RequiredArgsConstructor;
import org.example.springboot.analyticsservice.Api.DTO.Kafka.AnswersFormRequest;
import org.example.springboot.analyticsservice.Data.Entity.Answer;
import org.example.springboot.analyticsservice.Data.Entity.Poll;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PollMapper {

    private final AnswerMapper answerMapper;

    public Poll toPoll(AnswersFormRequest answersFormRequest) {
        List<Answer> answers = answersFormRequest.listOfAnswers().stream().map(answerMapper::toAnswer).toList();
        Poll poll =  new Poll();
        poll.setTypeOfPoll(answersFormRequest.typeOfPoll());
        poll.setPollId(answersFormRequest.pollId());
        poll.setAnswers(answers);

        return poll;
    }

}
