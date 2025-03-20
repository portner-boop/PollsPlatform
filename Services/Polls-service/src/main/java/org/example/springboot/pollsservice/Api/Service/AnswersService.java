package org.example.springboot.pollsservice.Api.Service;

import lombok.RequiredArgsConstructor;
import org.example.springboot.pollsservice.Api.DTO.Request.AnswersFormRequest;
import org.example.springboot.pollsservice.Api.DTO.Response.AnswersFormResponse;
import org.example.springboot.pollsservice.Api.PollsMapper.AnswerMapper;
import org.example.springboot.pollsservice.Api.PollsMapper.AnswersFormMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswersService {

    private final AnswersFormMapper answersFormMapper;
    private final AnswersProducerService answersProducerService;


    public AnswersFormResponse createAnswerForm(AnswersFormRequest answersFormRequest) {
        AnswersFormResponse answersFormResponse = answersFormMapper.toAnswersFormResponse(answersFormRequest);
        answersProducerService.sendAnswerConfirmation(answersFormResponse);
        return answersFormResponse;
    }
}
