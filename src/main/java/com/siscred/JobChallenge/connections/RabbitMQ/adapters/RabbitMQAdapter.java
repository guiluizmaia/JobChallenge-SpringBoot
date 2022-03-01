package com.siscred.JobChallenge.connections.RabbitMQ.adapters;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Service
public class RabbitMQAdapter implements IRabbitMQAdapter{

    private RabbitTemplate rabbitTemplate;
    
    private ObjectMapper objectMapper;

    public RabbitMQAdapter(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper){
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;    
    }

    @Override
    public void sendMessage(String exchange, String routingKey, Object message) {
        try {
          String mensagemJson = this.objectMapper.writeValueAsString(message);
          this.rabbitTemplate.convertAndSend("amq.direct", "scheduleRoutingKey", mensagemJson);
        } catch (Exception e){
          e.printStackTrace();
        }
    }
}
