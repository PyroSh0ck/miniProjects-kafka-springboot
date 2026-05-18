package kafka.springboot.order_service.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kafka.springboot.base_domains.dto.Order;
import kafka.springboot.base_domains.dto.OrderEvent;
import kafka.springboot.order_service.kafka.OrderProducer;

/*
 *
 * This creates an OrderController class with the @RestController
 * annotation. The point of this class is to handle HTTP reqeusts,
 * specifically those that are issued to [server_url]/api/v1. Specifically,
 * it tells Spring to make this class a component that handles web requests 
 * and for it to serialize return objects as JSON or XML instead of resolving
 * them as HTML. It is a meta annotation for @Controller and @ResponseBody.
 * @RequestMapping makes it so that it handles the specific endpoint url.
 * We then create a placeOrder method, which is anntotated with a @PostMapping 
 * annotation (dictating that it will handle a POST request to the url: 
 * /api/v1/orders). We then configure the OrderEvent object and send the message
 *
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {
  private OrderProducer orderProducer;

  // Constructor-based dependency injection again
  public OrderController(OrderProducer orderProducer) {
    this.orderProducer = orderProducer;
  }

  @PostMapping("/orders")
  public String placeOrder(@RequestBody Order order) {
    order.setOrderId(UUID.randomUUID().toString());

    OrderEvent orderEvent = new OrderEvent();
    orderEvent.setStatus("PENDING");
    orderEvent.setMessage("order status is in pending state");
    orderEvent.setOrder(order);

    orderProducer.sendMessage(orderEvent);

    return "Order placed successfully!";
  }
}
