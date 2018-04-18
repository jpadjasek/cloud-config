package com.cloud.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope
public class ClientApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);
    }
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${remote.prop}")
    private String remote;

    //@Value("${local.name}")
    private String local;

    @RequestMapping("/remote")
    String getRemonte() {
        return this.remote;
    }

    @RequestMapping("/local")
    String getLocal() {
        return this.local;
    }
}