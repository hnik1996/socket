package com.ebcom.websocket.Messaging.service;

import java.util.Map;

public interface RedisService {
    void findByUserId(String userId, Map<String, Object> data);
    void deleteByUserId(String userId);
}
