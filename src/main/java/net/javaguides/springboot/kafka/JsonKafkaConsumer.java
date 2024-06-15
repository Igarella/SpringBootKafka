package net.javaguides.springboot.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.javaguides.springboot.payload.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class JsonKafkaConsumer {

    @KafkaListener(topics = "javaguides_json", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        log.info(String.format("User Json was received -> %s", user.toString()));
        System.out.println();
    }
}
