package com.ebcom.websocket.Messaging.component;

import org.json.JSONObject;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(payload);
        } catch (Exception e) {
            session.close();
            return;
        }

        if (jsonObject.has("action")) {
            String action = jsonObject.get("action").toString();
            switch (action) {
                case "token":
                    break;
                case "login":
                    break;
                default:
                    break;

            }
        }
        session.sendMessage(new TextMessage("Hi " + jsonObject.get("user") + " how may we help you?"));
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
    }
}
