package br.com.sitedoph.travelenvironment;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import javax.annotation.PostConstruct;

/**
 * Created by ph on 6/21/16.
 */
@SpringCloudApplication
public class Application {

    @Autowired
    private CamelContext context;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() throws Exception {
        context.addComponent("rabbitmq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"));
    }

}

