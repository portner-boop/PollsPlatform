package org.example.springboot.pollsservice.Api.Controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.springboot.pollsservice.Api.DTO.Request.PollRequest;
import org.example.springboot.pollsservice.Api.DTO.Response.PollResponse;
import org.example.springboot.pollsservice.Api.Service.PollsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("api/v1/polls")
public class PollsController {

     PollsService pollsService;


    @GetMapping("/all_polls_with_elements")
    public ResponseEntity<List<PollResponse>> getAllPollsWithAllElements() {
        return ResponseEntity.ok(pollsService.getAllPollsWithQuestionsAndAnswers());
    }

    @GetMapping("/all_polls_without_elements")
    public ResponseEntity<List<PollResponse>> getAllPollsWithoutElements() {
        return ResponseEntity.ok(pollsService.getAllPollsWithoutElements());
    }

    @PostMapping("/create_poll")
    public ResponseEntity<PollResponse> createPoll(
            @RequestBody @Validated PollRequest pollRequest){
        return ResponseEntity.ok(pollsService.createPoll(pollRequest));

    }


}
