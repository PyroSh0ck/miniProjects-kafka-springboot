package kafka.springboot.order_service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import kafka.springboot.base_domains.dto.OrderEvent;

/*
 *
 * This effectively just creates a producer that sends a message 
 * to the Kafka broker. The service annotation defines a class as a spring bean class. 
 * There isn't much to say about this class, it is fairly self explanatory
 *
 */

@Service
// Remember, the service annotation makes order producer a spring bean class
// (whatever that means)
public class OrderProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

  private NewTopic topic;

  private KafkaTemplate<String, OrderEvent> kafkaTemplate;

  // we used constructor-based dependency injection here so the spring framework
  // can populate those objects for us
  public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
    this.topic = topic;
    this.kafkaTemplate = kafkaTemplate;
  }

  // Send message method (self explanatory, just sends a message to the kafka
  // topic)
  public void sendMessage(OrderEvent event) {
    LOGGER.info(String.format("Order event: %s", event.toString()));

    // create message:
    Message<OrderEvent> message = MessageBuilder
        .withPayload(event)
        .setHeader(KafkaHeaders.TOPIC, topic.name())
        .build();

    kafkaTemplate.send(message);
  }
}
