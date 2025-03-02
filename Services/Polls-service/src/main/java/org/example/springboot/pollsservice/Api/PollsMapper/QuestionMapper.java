package org.example.springboot.pollsservice.Api.PollsMapper;

import lombok.RequiredArgsConstructor;
import org.example.springboot.pollsservice.Api.DTO.Request.QuestionRequest;
import org.example.springboot.pollsservice.Api.DTO.Response.AnswerResponse;
import org.example.springboot.pollsservice.Api.DTO.Response.QuestionResponse;
import org.example.springboot.pollsservice.Data.Entities.Answer;
import org.example.springboot.pollsservice.Data.Entities.Question;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final AnswerMapper answerMapper;

    public QuestionResponse mapToQuestionResponse(Question question) {
        List<AnswerResponse> answerResponses = question.getAnswers().stream()
                .map(answerMapper::mapToAnswerResponse)
                .collect(Collectors.toList());

        return new QuestionResponse(
                question.getId(),
                question.getQuestion(),
                answerResponses
        );
    }
    public Question mapToQuestion(QuestionRequest questionRequest) {
        List<Answer> answers = questionRequest
                .getAnswers()
                .stream()
                .map(answerMapper::mapToAnswer)
                .toList();


        Question question = new Question();
        question.setQuestion(questionRequest.getQuestion());
        answers.forEach(a -> a.setQuestion(question));
        question.setAnswers(answers);

        return question;
    }
}
