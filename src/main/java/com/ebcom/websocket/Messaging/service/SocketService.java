package com.ebcom.websocket.Messaging.service;

import java.util.Map;

public interface SocketService {
    void findOpenedByUserId(String userId, Map<String, Object> data);

    void openConnection();
}
