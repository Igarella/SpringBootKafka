package net.javaguides.springboot.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.javaguides.springboot.payload.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;



@Service
@Log4j2
@RequiredArgsConstructor
public class JsonKafkaProducer {
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data) {
        log.info(String.format("Message was sent -> %s", data.toString()));
        String url = "http://localhost:8080/api/v1/kafka/publish";

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "javaguides_json")
                .build();

        kafkaTemplate.send(message);
    }
}
