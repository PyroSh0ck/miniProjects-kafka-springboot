
# This is a basic event-drive microservice-style architecture

## Advantages of Microservice architecture

1. It improves flexibility and maintainability.
2. Each service is only responsible for providing the requirements of the service,
   and they don't manage the delivery or throttling of their service to others.
3. It provides high scalability.
4. Improved availability.

## Initializing the Kafka Server

1. Make sure you've generated a KAFKA_CLUSTER_ID. There should already
be one generated, however if necessary run
`KAFKA_CLUSTER_ID = "$(bin/kafka-storage.sh random-uuid)"`. Then,
you should format the log directories via
`bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/server.properties`.
Lastly, you should start the Kafka server on a separate bash process via
`bin/kafka-server-start.sh config/server.properties`
