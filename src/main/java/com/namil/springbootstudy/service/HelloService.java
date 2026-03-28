package com.namil.springbootstudy.service;

import com.namil.springbootstudy.dto.HelloRequest;
import com.namil.springbootstudy.dto.HelloResponse;
import com.namil.springbootstudy.dto.UserResponse;
import com.namil.springbootstudy.entity.User;
import com.namil.springbootstudy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Service
public class HelloService {


    private final UserRepository userRepository;

    public HelloService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(HelloRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());

        return userRepository.save(user);
    }

    public HelloResponse hello(HelloRequest request) {
        return new HelloResponse(request.getName(), "응답시간");
    }

    public HelloResponse bye(HelloRequest request) {

        String currentTime = LocalTime.now().withNano(0).toString();
        return new HelloResponse("bye " + request.getName() + " (" + request.getAge() + ")", currentTime);
    }

    public UserResponse getUser(HelloRequest request) {
        return new UserResponse(null, request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user-> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .toList();
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        return new UserResponse(user.getId(), user.getName(), user.getAge());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserResponse updateUser(Long id, HelloRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        user.setName(request.getName());
        user.setAge(request.getAge());

        User updatedUser = userRepository.save(user);

        return new UserResponse(updatedUser.getId(), updatedUser.getName(), updatedUser.getAge());
    }

}
