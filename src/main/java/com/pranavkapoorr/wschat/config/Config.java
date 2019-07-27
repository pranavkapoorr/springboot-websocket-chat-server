package com.pranavkapoorr.wschat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;
import com.pranavkapoorr.wschat.handler.SocketHandler;

@Configuration
@EnableWebSocket
public class Config implements WebSocketConfigurer {
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new SocketHandler(), "/chat");
	}
}