package com.ebcom.websocket.websocket.repository;

import com.ebcom.websocket.websocket.model.InputData;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<InputData, String> {

}
