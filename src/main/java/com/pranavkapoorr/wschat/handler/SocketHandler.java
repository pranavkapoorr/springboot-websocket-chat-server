package com.pranavkapoorr.wschat.handler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.pranavkapoorr.wschat.model.Message;

@Component
public class SocketHandler extends TextWebSocketHandler {
	
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		
		for(WebSocketSession webSocketSession : sessions) {
			try{
				Message value = new Gson().fromJson(message.getPayload(),Message.class);
				webSocketSession.sendMessage(new TextMessage(new Gson().toJson(value)));
			}catch(JsonSyntaxException e) {
				webSocketSession.sendMessage(new TextMessage("Illegal Syntax! "+e.getCause()));
			}
			
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//the messages will be broadcasted to all users.
		sessions.add(session);
	}
}