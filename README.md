# Analyzer

Simple application that parse a JSON file, create and send message to a Amazon SQS.
 These messages are processed by the application that export metrics to Prometheus and can be visualized by Grafana.

## Requirements:

* Java 11.
* Docker and docker-compose installed and running.

## How to run:

**Running from Makefile:**

`make run-application` (This will run the commands above)

**Running from command line:**

1. First you need to run docker-compose to create the needed containers used by application.
 So, you can run from directory: `/docker` 
 the following command: `docker-compose up` or from another directory pointing up `docker-compose.yml` file using: `docker-compose -f ${PWD}/docker/docker-compose.yml up`

2. With docker-compose running, you can run: `mvn spring-boot:run` from the root application directory.

## Visualize Metrics:

To visualize metrics, access: http://localhost:9090. 

**Credentials:** \
**username:** admin \
**password:** admin

## Technologies:

* Java & Spring Boot.
* Amazon SQS provided by Localstack.
* Prometheus.
* Grafana.
