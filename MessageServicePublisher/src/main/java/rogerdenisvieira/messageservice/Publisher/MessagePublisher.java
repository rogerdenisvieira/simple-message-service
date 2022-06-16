package rogerdenisvieira.messageservice.Publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;


    @Autowired
    public MessagePublisher(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void sendMessage(String message){
        this.rabbitTemplate.convertAndSend(this.queue.getName(), message);
    }
}