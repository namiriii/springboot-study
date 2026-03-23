package com.namil.springbootstudy.service;

import com.namil.springbootstudy.dto.HelloRequest;
import com.namil.springbootstudy.dto.HelloResponse;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

@Service
public class HelloService {

    public HelloResponse hello(HelloRequest request) {
        return new HelloResponse(request.getName(), "응답시간");
    }

    public HelloResponse bye(HelloRequest request) {

        String currentTime = LocalTime.now().withNano(0).toString();
        return new HelloResponse("bye " + request.getName() + " (" + request.getAge() + ")", currentTime);
    }
}
