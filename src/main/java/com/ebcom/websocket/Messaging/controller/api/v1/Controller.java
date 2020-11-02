package com.ebcom.websocket.Messaging.controller.api.v1;


import com.ebcom.websocket.Messaging.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    private final RedisService redisService;

    @Autowired
    public Controller(RedisService redisService) {
        this.redisService = redisService;
    }

    @RequestMapping(value = "/ws/{userId}/confirm", method = RequestMethod.POST)
    public ResponseEntity<Object> confirm(@RequestBody Map<String, Object> data,
                                          @PathVariable("userId") String userId) {
        redisService.findByUserId(userId, data);
        return ResponseEntity.noContent().build();
    }
}
