package com.namil.springbootstudy.service;

import com.namil.springbootstudy.dto.HelloRequest;
import com.namil.springbootstudy.dto.HelloResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloResponse hello(HelloRequest request) {
        return new HelloResponse(request.getName(), "응답시간");
    }
}
