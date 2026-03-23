package com.namil.springbootstudy.controller;
import com.namil.springbootstudy.dto.HelloRequest;
import com.namil.springbootstudy.dto.HelloResponse;
import com.namil.springbootstudy.service.HelloService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public HelloResponse hello() {
        return new HelloResponse("hello spring boot", "10:00");
    }

    @PostMapping("/hello")
    public HelloResponse helloPost(@RequestBody HelloRequest request) {
        return helloService.hello(request);
    }

    @PostMapping("/bye")
    public HelloResponse byePost(@RequestBody @Valid HelloRequest request) {
        return helloService.bye(request);
    }


}
