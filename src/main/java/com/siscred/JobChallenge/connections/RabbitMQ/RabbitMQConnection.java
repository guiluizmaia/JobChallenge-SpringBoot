package com.siscred.JobChallenge.connections.RabbitMQ;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {

    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue createQueue(String queueName){
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange createExchange(String name){
        return new DirectExchange(name);
    }

    private Binding relation(Queue queue, DirectExchange exchange, String routingKey){
        return new Binding(
            queue.getName(), 
            Binding.DestinationType.QUEUE, 
            exchange.getName(), 
            routingKey, 
            null
        );
    }

    @PostConstruct
    private void add(){
        try{
        Queue scheduleQueue = this.createQueue("scheduleQueue");
        DirectExchange exchange = this.createExchange("amq.direct");
        System.out.println(exchange.getName() + " amq.direct");

        Binding bind = this.relation(scheduleQueue, exchange, "scheduleRoutingKey");

        this.amqpAdmin.declareQueue(scheduleQueue);
        this.amqpAdmin.declareExchange(exchange);
        this.amqpAdmin.declareBinding(bind);

        } catch(Exception e){
            System.out.println(e.getCause());
        }
    }
}
