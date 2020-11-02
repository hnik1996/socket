package com.ebcom.websocket.Messaging.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author Sergi Almar
 */
public class UserRepository {

	private Map<String, String> activeSessions = new ConcurrentHashMap<>();

	public void add(String sessionId, String userId) {
		activeSessions.put(sessionId, userId);
	}

	public String getUserId(String sessionId) {
		return activeSessions.get(sessionId);
	}

	public void removeUserId(String sessionId) {
		activeSessions.remove(sessionId);
	}

	public Map<String, String> getActiveSessions() {
		return activeSessions;
	}

	public void setActiveSessions(Map<String, String> activeSessions) {
		this.activeSessions = activeSessions;
	}
}
