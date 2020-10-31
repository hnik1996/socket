package com.ebcom.websocket.websocket.service.impl;

import com.ebcom.websocket.websocket.model.InputData;
import com.ebcom.websocket.websocket.repository.RedisRepository;
import com.ebcom.websocket.websocket.service.RedisService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class RedisServiceImpl implements RedisService {
    private final RedisRepository redisRepository;
    private final RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public RedisServiceImpl(RedisRepository redisRepository, RedisConnectionFactory redisConnectionFactory) {
        this.redisRepository = redisRepository;
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @PostConstruct
    private void save() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("userId", UUID.randomUUID().toString());
        stringObjectHashMap.put("clientId", UUID.randomUUID().toString());
        InputData inputData = new InputData(UUID.randomUUID().toString(), "save", stringObjectHashMap, new Date().getTime(), UUID.randomUUID().toString(),0L);
        InputData save = redisRepository.save(inputData);
        Optional<InputData> byId = redisRepository.findById(save.getId());
        JsonNode jsonNode = new ObjectMapper().valueToTree(byId.get());
        System.out.println(jsonNode);
    }
}
