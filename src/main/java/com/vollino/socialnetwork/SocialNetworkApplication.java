package com.vollino.socialnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@Import(AppConfiguration.class)
@SpringBootApplication
public class SocialNetworkApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SocialNetworkApplication.class, args);
    }
}
