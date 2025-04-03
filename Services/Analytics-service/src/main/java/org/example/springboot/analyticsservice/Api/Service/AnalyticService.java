package org.example.springboot.analyticsservice.Api.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboot.analyticsservice.Api.DTO.Analytic.TestAnalyticResponse;
import org.example.springboot.analyticsservice.Api.DTO.Kafka.AnswersFormRequest;
import org.example.springboot.analyticsservice.Api.DTO.RestObject.PollAnalytics;
import org.example.springboot.analyticsservice.Api.Exception.NotFoundUserException;
import org.example.springboot.analyticsservice.Api.Mapper.Analytic.TestAnalyticResponseMapperForAnalytic;
import org.example.springboot.analyticsservice.Api.Mapper.PollMapper;
import org.example.springboot.analyticsservice.Api.Mapper.Test.TestAnalyticResponseMapperForTest;
import org.example.springboot.analyticsservice.Data.Entity.Poll;
import org.example.springboot.analyticsservice.Data.Entity.PollsCompletedByUser;
import org.example.springboot.analyticsservice.Data.Repository.PollRepository;
import org.example.springboot.analyticsservice.Data.Repository.PollsCompleteByUserRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class AnalyticService {

    private final PollsCompleteByUserRepository pollsCompleteByUser;
    private final PollRepository pollRepository;
    private final PollMapper pollMapper;
    private final GettingPollService gettingPollService;
    private final TestAnalyticResponseMapperForTest testAnalyticResponseMapperForTest;
    private final TestAnalyticResponseMapperForAnalytic testAnalyticResponseMapperForAnalytic;
    private final PollsCompleteByUserRepository pollsCompleteByUserRepository;

    @KafkaListener(topics = "answers-topic", groupId = "analytic-service-group")
    @Transactional
    public void listen(AnswersFormRequest answersFormRequest) {
        log.info("Received answer confirmation in AnalyticService: {}", answersFormRequest);
        processAnswerFormResponse(answersFormRequest);
    }

    private void processAnswerFormResponse(AnswersFormRequest request) {


        String userId = String.valueOf(request.userId());

        if (!(pollsCompleteByUser.existsPollsCompletedByUserId(userId))){

            PollsCompletedByUser user = new PollsCompletedByUser();
            user.setUserId(userId);
            user.setPolls(new ArrayList<>());
            saveResultOfUser(user, request);
            log.info("Created new user with userId: {}", userId);
        } else {
            PollsCompletedByUser user = pollsCompleteByUser.findByUserId(userId)
                    .orElseThrow(() -> new NotFoundUserException("Not Found this user with id: "+ userId));
            saveResultOfUser(user, request);
            log.info("User with userId: {} already exists", userId);

        }

    }
    public void saveResultOfUser(PollsCompletedByUser user,AnswersFormRequest request) {
        Poll poll =  pollMapper.toPoll(request);
        user.addPoll(poll);
        pollsCompleteByUser.save(user);

    }

    public TestAnalyticResponse getAnalyticForTest(Long pollId) {

        PollAnalytics pollAnalytics = gettingPollService.getPollById(pollId);

        switch(pollAnalytics.typeOfPoll()){
            case ("TEST") -> {
                return testAnalyticResponseMapperForTest.toTestAnalyticResponse(pollAnalytics);
            }
            case ("STATISTICS") -> {
                return testAnalyticResponseMapperForAnalytic.toTestAnalyticResponse(pollAnalytics);
            }

        }
        throw new NotFoundUserException("Not Found this poll");
    }

    public Boolean checkTestDoneByUser(String userId,Long pollId) {

        PollsCompletedByUser pollsCompletedByUser =pollsCompleteByUserRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundUserException("Not Found this user"));

        Optional<Long> pollIdOptional = pollsCompletedByUser.getPolls()
                .stream()
                .filter(e -> e.getPollId().equals(pollId))
                .map(Poll::getPollId)
                .findAny();

        if(pollIdOptional.isPresent()){
            return true;
        }

        return false;
    }
}
