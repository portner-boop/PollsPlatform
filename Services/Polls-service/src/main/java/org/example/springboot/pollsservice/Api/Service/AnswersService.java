package org.example.springboot.pollsservice.Api.Service;

import lombok.RequiredArgsConstructor;
import org.example.springboot.pollsservice.Api.DTO.Request.AnswersFormRequest;
import org.example.springboot.pollsservice.Api.DTO.Response.AnswersFormResponse;
import org.example.springboot.pollsservice.Api.PollsMapper.AnswersFormMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswersService {

    private final AnswersFormMapper answersFormMapper;

    public AnswersFormResponse createAnswerForm(AnswersFormRequest answersFormRequest) {
        return answersFormMapper.toAnswersFormResponse(answersFormRequest);
    }
}
