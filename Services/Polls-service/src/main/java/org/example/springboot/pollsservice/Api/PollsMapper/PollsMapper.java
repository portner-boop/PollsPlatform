package org.example.springboot.pollsservice.Api.PollsMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springboot.pollsservice.Api.DTO.Request.PollRequest;
import org.example.springboot.pollsservice.Api.DTO.Response.PollResponse;
import org.example.springboot.pollsservice.Api.DTO.Response.QuestionResponse;
import org.example.springboot.pollsservice.Data.Entities.Poll;
import org.example.springboot.pollsservice.Data.Entities.Question;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class PollsMapper {

    private final QuestionMapper questionMapper;


    public PollResponse mapToPollResponseWithQuestionsAndAnswers(Poll poll) {
        List<QuestionResponse> list= poll.getQuestions()
                .stream()
                .map(questionMapper::mapToQuestionResponse)
                .toList();

        return PollResponse
                .builder()
                .id(poll.getId())
                .title(poll.getTitle())
                .dateOfCreation(poll.getDateOfCreation())
                .description(poll.getDescription())
                .typeOfPoll(poll.getTypeOfPoll())
                .questions(list)
                .build();
    }
    public PollResponse mapToPollResponseWithoutQuestionsAndAnswers(Poll poll) {

        return PollResponse
                .builder()
                .id(poll.getId())
                .title(poll.getTitle())
                .dateOfCreation(poll.getDateOfCreation())
                .description(poll.getDescription())
                .typeOfPoll(poll.getTypeOfPoll())
                .questions(null)
                .build();
    }

    public Poll mapToPoll(PollRequest poll) {
        List<Question> questions = poll
                .getQuestions()
                .stream()
                .map(questionMapper::mapToQuestion)
                .toList();

        Poll newPoll = new Poll();
        newPoll.setTitle(poll.getTitle());
        newPoll.setDescription(poll.getDescription());
        newPoll.setTypeOfPoll(poll.getTypeOfPoll());
        questions.forEach(q -> q.setPoll(newPoll));
        newPoll.setQuestions(questions);

        return newPoll;
    }



}
