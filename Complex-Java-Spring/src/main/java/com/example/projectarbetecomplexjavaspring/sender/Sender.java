package com.example.projectarbetecomplexjavaspring.sender;

import com.example.projectarbetecomplexjavaspring.config.JmsConfig;
import com.example.projectarbetecomplexjavaspring.message.Message;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Sender {

    JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 4000)
    public void sendMessage() {

        System.out.println("Sending message...");
        Message message = new Message(UUID.randomUUID(),"Hej!", LocalDateTime.now());
        jmsTemplate.convertAndSend(JmsConfig.JU20_QUEUE, message);
        System.out.println("Message sent!");
    }

}
