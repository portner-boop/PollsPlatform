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
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class PollsMapper {

    private final QuestionMapper questionMapper;

    public List<PollResponse> mapToPollResponses(List<Poll> polls) {
        return polls.stream()
                .map(this::mapToPollResponseWithQuestion)
                .collect(Collectors.toList());
    }

    public PollResponse mapToPollResponseWithQuestion(Poll poll) {
        List<QuestionResponse> questionResponses = poll.getQuestions().stream()
                .map(questionMapper::mapToQuestionResponse)
                .collect(Collectors.toList());

        return new PollResponse(
                poll.getId(),
                poll.getTitle(),
                poll.getDescription(),
                poll.getDateOfCreation(),
                questionResponses
        );
    }
    public PollResponse mapToPollResponse(Poll poll) {
        return new PollResponse(
                poll.getId(),
                poll.getTitle(),
                poll.getDescription(),
                poll.getDateOfCreation(),
                null
        );
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
        questions.forEach(q -> q.setPoll(newPoll));
        newPoll.setQuestions(questions);

        return newPoll;

    }



}
