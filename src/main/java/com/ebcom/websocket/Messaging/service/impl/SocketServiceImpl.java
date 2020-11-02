package com.ebcom.websocket.Messaging.service.impl;

import com.ebcom.websocket.Messaging.model.InputData;
import com.ebcom.websocket.Messaging.service.SocketService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SocketServiceImpl implements SocketService {


    @Override
    public void findOpenedByUserId(String userId, Map<String, Object> data) {
        //if connection find by user id
        InputData inputData = new InputData();
        inputData.setAction("confirm");
        inputData.setData(data);
        //TODO send via socket
          //close socket
    }

    @Override
    public void openConnection() {

    }
}
