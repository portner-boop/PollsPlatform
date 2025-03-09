package org.example.springboot.pollsservice.Api.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springboot.pollsservice.Api.DTO.Response.AnswersFormResponse;
import org.example.springboot.pollsservice.Data.Entities.Answer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnswersProducerService {

    private final KafkaTemplate<String, AnswersFormResponse> kafkaTemplate;

    public void sendAnswerConfirmation(AnswersFormResponse answerFormResponse) {

        log.info("Sending answer confirmation");
        Message<AnswersFormResponse> message = MessageBuilder
                .withPayload(answerFormResponse)
                .setHeader(KafkaHeaders.TOPIC,"answers-topic")
                .build();

        kafkaTemplate.send(message);

    }
}
