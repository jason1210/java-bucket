package com.jason.demo.http.client;

import com.jason.demo.http.model.req.LoginUserReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "test-xnxw", path = "/", url = "http://localhost:8080")
public interface TestClient {

    @GetMapping("/xnxw/release/detail/{id}")
    String get(@PathVariable Long id);

    @PostMapping("/xnxw/admin/login")
    String post(@RequestBody LoginUserReq req);

}