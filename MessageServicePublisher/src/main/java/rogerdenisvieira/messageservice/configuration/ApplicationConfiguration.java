package rogerdenisvieira.messageservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfiguration {

    @Value("${exchange.name}")
    private String exchangeName;

    @Value("${queue.name}")
    private String queueName;


    public String getExchangeName() {
        return exchangeName;
    }

    public String getQueueName() {
        return queueName;
    }
}

