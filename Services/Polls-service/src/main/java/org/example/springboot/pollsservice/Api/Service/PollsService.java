package org.example.springboot.pollsservice.Api.Service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.springboot.pollsservice.Api.DTO.Request.PollRequest;
import org.example.springboot.pollsservice.Api.DTO.Response.PollResponse;
import org.example.springboot.pollsservice.Api.Exceptions.AlreadyExistPollException;
import org.example.springboot.pollsservice.Api.Exceptions.NotFoundPollException;
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
        return pollRepository.findAll().stream()
                .map(pollsMapper::mapToPollResponseWithQuestionsAndAnswers)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PollResponse> getAllPollsWithoutElements() {
        return pollRepository.findAll().stream()
                .map(pollsMapper::mapToPollResponseWithoutQuestionsAndAnswers)
                .collect(Collectors.toList());
    }

    @Transactional
    public PollResponse createPoll(PollRequest pollRequest) {
        if (pollRepository.existsByTitle(pollRequest.getTitle())) {
            throw new AlreadyExistPollException("The poll with this title already exists");
        }
        Poll poll = pollsMapper.mapToPoll(pollRequest);
        Poll savedPoll = pollRepository.save(poll);
        return pollsMapper.mapToPollResponseWithQuestionsAndAnswers(savedPoll);
    }

    @Transactional
    public PollResponse getPollByTitle(Long id) {
        Poll poll = pollRepository.
                findPollById(id)
                .orElseThrow(()-> new NotFoundPollException("Not found poll with id: " + id));

        List<Question> questions = questionRepository.findAllByPollIdWithAnswers(id);
        poll.setQuestions(questions);
        return pollsMapper.mapToPollResponseWithQuestionsAndAnswers(poll);
    }

    @Transactional
    public void deletePoll(Long id) {
        if (!pollRepository.existsById(id)) {
            throw new NotFoundPollException("Not found this poll with id: " + id);
        }
        pollRepository.deleteById(id);

    }
}
