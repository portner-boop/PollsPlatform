package org.example.springboot.pollsservice.Api.PollsMapper;

import lombok.RequiredArgsConstructor;
import org.example.springboot.pollsservice.Api.DTO.Response.PollsResponse.AnswerResponse;
import org.example.springboot.pollsservice.Api.DTO.Response.PollsResponse.PollResponse;
import org.example.springboot.pollsservice.Api.DTO.Response.PollsResponse.QuestionResponse;
import org.example.springboot.pollsservice.Data.Entities.Answer;
import org.example.springboot.pollsservice.Data.Entities.Poll;
import org.example.springboot.pollsservice.Data.Entities.Question;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PollsMapper {

    private final QuestionMapper questionMapper;

    public List<PollResponse> mapToPollResponses(List<Poll> polls) {
        return polls.stream()
                .map(this::mapToPollResponse)
                .collect(Collectors.toList());
    }

    public PollResponse mapToPollResponse(Poll poll) {
        List<QuestionResponse> questionResponses = poll.getQuestions().stream()
                .map(this::mapToQuestionResponse)
                .collect(Collectors.toList());

        return new PollResponse(
                poll.getId(),
                poll.getTitle(),
                poll.getDescription(),
                poll.getDateOfCreation(),
                questionResponses
        );
    }
    private QuestionResponse mapToQuestionResponse(Question question) {
        List<AnswerResponse> answerResponses = question.getAnswers().stream()
                .map(this::mapToAnswerResponse)
                .collect(Collectors.toList());

        return new QuestionResponse(
                question.getId(),
                question.getQuestion(),
                answerResponses
        );
    }
    private AnswerResponse mapToAnswerResponse(Answer answer) {
        return new AnswerResponse(
                answer.getId(),
                answer.getAnswer(),
                answer.isCorrectness()
        );
    }

}
