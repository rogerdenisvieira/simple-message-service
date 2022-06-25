package rogerdenisvieira.messageservice.publisher;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    private final DirectExchange exchange;


    @Autowired
    public MessagePublisher(RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void sendMessage(String message){

        this.rabbitTemplate.convertAndSend(exchange.getName(), "test-routing-key", message);
    }
}
