package com.ebcom.websocket.Messaging.event;

import com.ebcom.websocket.Messaging.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Optional;

public class UserEventListener {
    private final SimpMessagingTemplate messagingTemplate;
    private final UserRepository userRepository;

    @Autowired
    public UserEventListener(SimpMessagingTemplate messagingTemplate, UserRepository userRepository) {
        this.messagingTemplate = messagingTemplate;
        this.userRepository = userRepository;
    }

    @EventListener
    public void handleSessionConnected(SessionConnectEvent event) {
        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
        String userId = event.getMessage().toString();
        userRepository.add(headers.getSessionId(), userId);
    }

    @EventListener
    public void handleSessionDisconnect(SessionDisconnectEvent event) {

        Optional.ofNullable(userRepository.getUserId(event.getSessionId())).ifPresent(session -> userRepository.removeUserId(event.getSessionId()));
    }
}
