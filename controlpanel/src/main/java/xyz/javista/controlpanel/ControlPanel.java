package xyz.javista.controlpanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Created by Luke on 2017-03-20.
 */

@SpringBootApplication
public class ControlPanel {

    public static void main(String[] args) {
        SpringApplication.run(ControlPanel.class, args);
    }

    @Bean
    MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}
