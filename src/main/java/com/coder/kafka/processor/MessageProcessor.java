package com.coder.kafka.processor;

import com.coder.kafka.document.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stream")
public class MessageProcessor {

    @Autowired
    KafkaTemplate<String, UserDetails> kafkaTemplate;

    public static final String TOPIC = "code_test";

    @PostMapping("/kafka/user")
    public UserDetails publishUser(@RequestBody UserDetails userDetails){
        kafkaTemplate.send(TOPIC, userDetails);
        return userDetails;
    }
}
