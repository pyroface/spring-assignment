package com.example.projectarbetecomplexjavaspring.receiver;

import com.example.projectarbetecomplexjavaspring.config.JmsConfig;
import com.example.projectarbetecomplexjavaspring.message.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = JmsConfig.JU20_QUEUE)
    public void listen(@Payload Message message){
        System.out.println("I received a message!");
        System.out.println(message);
    }
}
