package com.ebcom.websocket.Messaging.repository;

import com.ebcom.websocket.Messaging.model.InputData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<InputData, String> {

}
