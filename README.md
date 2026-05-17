
# This is a basic event-drive microservice-style architecture

## Advantages of Microservice architecture

1. It improves flexibility and maintainability.
2. Each service is only responsible for providing the requirements of the service,
   and they don't manage the delivery or throttling of their service to others.
3. It provides high scalability.
4. Improved availability.

## Initializing the Kafka Server

1. First download and extract Kafka from the website.
Then make sure you've generated a KAFKA_CLUSTER_ID. In order to generate
a KAFKA_CLUSTER_ID, please run (note that all of these commands should be
run in the Kafka folder)
`KAFKA_CLUSTER_ID = "$(bin/kafka-storage.sh random-uuid)"`. Then,
you should format the log directories via
`bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/server.properties`.
Lastly, you should start the Kafka server on a separate bash process via
`bin/kafka-server-start.sh config/server.properties`

Afterward, you must leave this terminal open. In another terminal,
run `bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092`

## Generating the 4 microservices

The 4 microservices are base-domains, email-service, order-service, and stock-service.
They were all generated via Spring Initializr with various dependencies.
The latter 3 services used the Kafka and Web dependencies for Springboot, while
base-domains used Lumbok.

### Modifying the microservices

Each of the microservices will attempt to use port 8080, and this is not desirable
since they should all run on their own ports. Hence, we need to modify the application.properties
file and specify the port. One can simply write: `server.port=8081`.
