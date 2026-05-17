package kafka.springboot.base_domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 
 * This class is just going to be used to create the Order objects
 * The properties of the class should be pretty self-explanatory,
 * however it does use Lombok annotations so we don't have to write
 * some repetitive methods. @Data will create a to_string method,
 * a hash method, and an equals method, along with gets and sets.
 * @AllArgsConstructor and @NoArgsConstructor are also self-explanatory.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  private String orderId;
  private String name;
  private int qty;
  private double price;

}
