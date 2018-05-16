package com.cloud.server.client;

import com.cloud.server.client.mode.TestDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
public class BaseForFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(BaseForFeignApp.class, args);
    }
}

@RefreshScope
@RestController
class MessageRestController {

    //@Value("${remote.prop}")
    private String remote;

    //@Value("${local.name}")
    private String local;

    @RequestMapping("/remote")
    String getRemote() {
        return "DUPA";
    }

    @RequestMapping("/post")

    TestDto changePost(   @RequestBody TestDto testDto) {
        testDto.setAge(22);
        testDto.setName("new Name");
        return testDto;
    }
}