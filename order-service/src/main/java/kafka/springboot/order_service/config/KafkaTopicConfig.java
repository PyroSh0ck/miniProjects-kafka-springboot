package kafka.springboot.order_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/*
 *
 * This will automatically create a new topic within the Kafka broker whenever
 * we run this function. There are a couple of annotations that are significant
 * here, namely the Configuration annotation and the Bean annotation. 
 * @Configuration details this class as a config for spring beans, and 
 * @Bean creates the method as a spring bean. 
 *
 */

@Configuration // Annotation turns this class into a spring based java config
// within this class, you can define spring beans
public class KafkaTopicConfig {

  @Value("${spring.kafka.topic.name}") // Used to retrieve a property value, and we need to pass in the property key
  private String topicName; // So with the annotation, we have the topic name
  // Since spring.kafka.topic.name=order_name

  // spring bean for kafka topic
  @Bean // Used so spring recognizes this method as a spring bean
  public NewTopic topic() {
    return TopicBuilder.name(topicName).build(); // Will create a new topic instance with the given name
  }
}
