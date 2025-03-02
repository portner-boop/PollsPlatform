package org.example.springboot.pollsservice.Api.PollsMapper;

import lombok.RequiredArgsConstructor;
import org.example.springboot.pollsservice.Api.DTO.Response.PollsResponse.QuestionResponse;
import org.example.springboot.pollsservice.Data.Entities.Question;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final AnswerMapper answerMapper;

    public QuestionResponse toQuestionResponse(Question question) {
        return QuestionResponse
                .builder()
                .id(question.getId())
                .question(question.getQuestion())
                .answers(question
                        .getAnswers()
                        .stream()
                        .map(answerMapper::toAnswerResponse)
                        .toList())
                .build();
    }
}
