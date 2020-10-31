package com.ebcom.websocket.websocket.controller.api.v1;


import com.ebcom.websocket.websocket.model.InputData;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public InputData greeting(InputData inputData) throws Exception {
        Thread.sleep(1000); // simulated delay
        return inputData;
    }
}
