package ru.sstu.rosatom;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;

@SpringBootApplication
public class RosatomApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext a = SpringApplication.run(RosatomApplication.class, args);
    }

}
