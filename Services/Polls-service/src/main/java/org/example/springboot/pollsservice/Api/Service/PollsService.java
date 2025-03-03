package org.example.springboot.pollsservice.Api.Service;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.springboot.pollsservice.Api.DTO.Request.PollRequest;
import org.example.springboot.pollsservice.Api.DTO.Response.PollResponse;
import org.example.springboot.pollsservice.Api.Exceptions.AlreadyExistPollExсeption;
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
        List<Poll> polls = pollRepository.findAllWithQuestions();
        polls.forEach(poll -> {
            List<Question> questions = questionRepository.findAllByPollIdWithAnswers(poll.getId());
            poll.setQuestions(questions);
        });
        return pollsMapper.mapToPollResponses(polls);
    }
    @Transactional
    public List<PollResponse> getAllPollsWithoutElements() {
        return pollRepository.findAll().stream()
                .map(pollsMapper::mapToPollResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public PollResponse createPoll(PollRequest pollRequest) {
        if (pollRepository.existsByTitle(pollRequest.getTitle())) {
            throw new AlreadyExistPollExсeption("The poll with this title already exists");
        }
        Poll poll = pollsMapper.mapToPoll(pollRequest);
        Poll savedPoll = pollRepository.save(poll);
        System.out.println("Saved poll: " + savedPoll);
        return pollsMapper.mapToPollResponse(savedPoll);
    }
    @Transactional
    public PollResponse getPollByTitle(Long id) {
        return pollsMapper
                .mapToPollResponse(pollRepository
                .findPollById(id)
                .orElseThrow(() -> new NotFoundPollException( "Not found this poll with id: " + id)));
    }
    @Transactional
    public void deletePoll(Long id) {
        if (!pollRepository.existsById(id)) {
            throw new NotFoundPollException("Not found this poll with id: " + id);
        }
        pollRepository.deleteById(id);

    }
}
