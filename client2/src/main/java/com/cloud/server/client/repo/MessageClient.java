package com.cloud.server.client.repo;

import com.cloud.server.client.model.TestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "base-for-feign")
@Repository
public interface MessageClient {

    @GetMapping("/remote")
    String getRemote();

    @GetMapping("/post")
    TestDto putChange(TestDto testDto);
}