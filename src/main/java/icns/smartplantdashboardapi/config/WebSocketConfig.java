package icns.smartplantdashboardapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/send", "/alert");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

      registry.addEndpoint("/ws").setAllowedOrigins("http://163.180.117.38","server.inhun.io").withSockJS();

    }
}
