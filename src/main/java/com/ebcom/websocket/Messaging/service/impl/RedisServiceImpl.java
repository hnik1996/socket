package com.ebcom.websocket.Messaging.service.impl;

import com.ebcom.websocket.Messaging.exception.BadRequestException;
import com.ebcom.websocket.Messaging.model.InputData;
import com.ebcom.websocket.Messaging.repository.RedisRepository;
import com.ebcom.websocket.Messaging.service.RedisService;
import com.ebcom.websocket.Messaging.service.SocketService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RedisServiceImpl implements RedisService {
    private final RedisRepository redisRepository;
    private final SocketService socketService;

    @Autowired
    public RedisServiceImpl(RedisRepository redisRepository,
                            @Lazy SocketService socketService) {
        this.redisRepository = redisRepository;
        this.socketService = socketService;
    }

    @Override
    public void findByUserId(String userId, Map<String, Object> data) {
        Optional<InputData> optionalData = redisRepository.findById(userId);
        if (!optionalData.isPresent()) throw new BadRequestException("user id not found");
        socketService.findOpenedByUserId(userId, data);


    }

    @Override
    public void deleteByUserId(String userId) {
        redisRepository.deleteById(userId);
    }

    private void save() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("userId", UUID.randomUUID().toString());
        stringObjectHashMap.put("clientId", UUID.randomUUID().toString());
        String id = UUID.randomUUID().toString();
        InputData inputData = new InputData(id, "save", stringObjectHashMap, new Date().getTime(), UUID.randomUUID().toString(), 0L);
        InputData save = redisRepository.save(inputData);
        Optional<InputData> byId = redisRepository.findById(id);
        JsonNode jsonNode = new ObjectMapper().valueToTree(byId.get());
        System.out.println(jsonNode);
    }
}
