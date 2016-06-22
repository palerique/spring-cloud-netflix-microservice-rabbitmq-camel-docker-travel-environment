package br.com.sitedoph.travelenvironment;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

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
