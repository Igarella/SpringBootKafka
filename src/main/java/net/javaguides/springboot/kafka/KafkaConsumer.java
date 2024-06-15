package net.javaguides.springboot.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class KafkaConsumer {

    @KafkaListener(topics = "javaguides", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info(String.format("Message received -> %s", message));
    }
}
