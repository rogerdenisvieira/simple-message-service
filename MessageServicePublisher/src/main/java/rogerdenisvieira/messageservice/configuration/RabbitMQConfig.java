package rogerdenisvieira.messageservice.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final ApplicationConfiguration appConfig;

    @Autowired
    public RabbitMQConfig(ApplicationConfiguration appConfig) {
        this.appConfig = appConfig;
    }


    @Bean
    public Queue queue() {
        return new Queue(appConfig.getQueueName(), true);
    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(appConfig.getExchangeName());
    }

    @Bean
    public Binding testBinding(Queue queue, DirectExchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("test-routing-key");
    }


}
