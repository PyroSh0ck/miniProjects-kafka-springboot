package kafka.springboot.email_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import kafka.springboot.base_domains.dto.OrderEvent;

/*
 *
 * The OrderConsumer class simply consumes messages from a partition in a topic 
 * from the Kafka broker. The @KafkaListener annotation turns the consume function
 * into a bean method as a listener for a listener container. It turns the function
 * into a MessagingMessageLIstenerAdapter. The @Service annotation is just a generic
 * bean configuration.
 *
 */
@Service
public class OrderConsumer {
  // Log the event that we consume from the kafka topic
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

  @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(OrderEvent event) {
    LOGGER.info(String.format("Order event received in email service: %s", event.toString()));

    // Send an email to the customer
  }
}
