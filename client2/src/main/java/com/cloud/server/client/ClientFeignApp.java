package com.cloud.server.client;

import com.cloud.server.client.model.TestDto;
import com.cloud.server.client.repo.MessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
@EnableFeignClients
public class ClientFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientFeignApp.class, args);
    }
}

@RestController
class MessageRestController {

    private final MessageClient messageClient;

    //@Value("${local.name}")
    private String local;

    public MessageRestController(MessageClient messageClient) {
        this.messageClient = messageClient;
    }

    @GetMapping("/remote")
    String getRemonte() {
        return messageClient.getRemote();
    }

    @GetMapping("/post")
    TestDto changeMessage() {
        TestDto testDto = new TestDto();
        testDto.setAge(11);
        testDto.setName("name");
        return messageClient.putChange(testDto);
    }



}