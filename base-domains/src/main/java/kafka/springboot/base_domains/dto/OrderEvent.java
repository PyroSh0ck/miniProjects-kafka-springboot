package kafka.springboot.base_domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *
 * This is the class that's going to be used for transferring Data
 * through Apache Kafka, and its properties should also be fairly
 * self-explanatory.
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
  private String message;
  private String status;
  private Order order;
}
