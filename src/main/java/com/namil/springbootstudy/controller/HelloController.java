package com.namil.springbootstudy.controller;
import com.namil.springbootstudy.dto.HelloRequest;
import com.namil.springbootstudy.dto.HelloResponse;
import com.namil.springbootstudy.dto.UserResponse;
import com.namil.springbootstudy.entity.User;
import com.namil.springbootstudy.service.HelloService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @PostMapping("/user")
    public UserResponse user(@RequestBody @Valid HelloRequest request) {
        return helloService.getUser(request);
    }

    @PostMapping("/save-user")
    public User saveUser(@RequestBody @Valid HelloRequest request) {
        return helloService.saveUser(request);
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        return helloService.getUsers();
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return helloService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        helloService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody HelloRequest request) {
        return helloService.updateUser(id, request);
    }


}
