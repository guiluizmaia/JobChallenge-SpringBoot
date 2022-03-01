package com.siscred.JobChallenge.connections.RabbitMQ.adapters;

public interface IRabbitMQAdapter {
    void sendMessage(String exchange, String routingKey, Object message);
}
