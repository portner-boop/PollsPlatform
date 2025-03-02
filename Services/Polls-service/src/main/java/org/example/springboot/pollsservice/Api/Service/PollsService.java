package org.example.springboot.pollsservice.Api.Service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.springboot.pollsservice.Api.DTO.Response.PollsResponse.PollResponse;
import org.example.springboot.pollsservice.Api.PollsMapper.PollsMapper;
import org.example.springboot.pollsservice.Data.Entities.Poll;
import org.example.springboot.pollsservice.Data.Entities.Question;
import org.example.springboot.pollsservice.Data.Repository.PollRepository;
import org.example.springboot.pollsservice.Data.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class PollsService {

    PollRepository pollRepository;
    PollsMapper pollsMapper;
    QuestionRepository questionRepository;

    @Transactional
    public List<PollResponse> getAllPollsWithQuestionsAndAnswers() {
        List<Poll> polls = pollRepository.findAllWithQuestions();
        polls.forEach(poll -> {
            List<Question> questions = questionRepository.findAllByPollIdWithAnswers(poll.getId());
            poll.setQuestions(questions);
        });
        return pollsMapper.mapToPollResponses(polls);
    }
}
