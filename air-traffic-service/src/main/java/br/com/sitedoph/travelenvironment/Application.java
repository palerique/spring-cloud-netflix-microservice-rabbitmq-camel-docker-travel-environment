package br.com.sitedoph.travelenvironment;

import br.com.sitedoph.travelenvironment.domain.Flight;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Created by ph on 6/21/16.
 */
@SpringCloudApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

@RestController
class MusketeersController {

    @RequestMapping("/musketeers")
    public Collection<String> musketeers() {
        return Arrays.asList("Athos", "Porthos", "Aramis");
    }

}

@RestController
class CreateNewFlightController {

    private final static String queueName = "airtraffic-departures-queue";

    @Autowired
    private
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/flight")
    public ResponseEntity<String> createNewFlight() {
        try {
            for (int i = 0; i < 1000; i++) {
                rabbitTemplate.convertAndSend(queueName, new Flight("Brasília", "Dublin", "AIRBUS A380", LocalDateTime.now(), "TAM" + i));
            }
            return new ResponseEntity<>("Message sent to AMQP queue at: " + new Date(), HttpStatus.OK);
        } catch (AmqpException amqpEx) {
            return new ResponseEntity<>(amqpEx.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
