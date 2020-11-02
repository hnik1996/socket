package com.ebcom.websocket.Messaging.configuration;

import com.ebcom.websocket.Messaging.event.UserEventListener;
import com.ebcom.websocket.Messaging.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Configuration
public class MessagingConfig {

    @Bean
    @Description("Tracks user presence (join / leave) and broadcasts it to all connected users")
    public UserEventListener userEventListener(SimpMessagingTemplate messagingTemplate) {
        return new UserEventListener(messagingTemplate, participantRepository());
    }

    @Bean
    @Description("Keeps connected users")
    public UserRepository participantRepository() {
        return new UserRepository();
    }
}
