package com.siscred.JobChallenge.conections.RabbitMQ.adapters;

public interface IRabbitMQAdapter {
    void sendMessage(String exchange, String routingKey, Object message);
}
