package com.namil.springbootstudy.service;

import com.namil.springbootstudy.dto.HelloRequest;
import com.namil.springbootstudy.dto.UserResponse;
import com.namil.springbootstudy.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void 유저_저장_테스트() {
        //given
        HelloRequest request = new HelloRequest();
        request.setName("namil");
        request.setAge(20);

        //when
        User user = helloService.saveUser(request);

        //then
        assertThat(user.getName()).isEqualTo("namil");
        assertThat(user.getAge()).isEqualTo(20);

    }

    @Test
    void 유저_전체조회_테스트() {
        //given
        HelloRequest request1 = new HelloRequest();
        request1.setName("a");
        request1.setAge(10);

        HelloRequest request2 = new HelloRequest();
        request2.setName("b");
        request2.setAge(20);

        helloService.saveUser(request1);
        helloService.saveUser(request2);

        //when
        List<UserResponse> users = helloService.getUsers();

        //then
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    void 유저_단건조회_테스트() {

        //given
        HelloRequest request = new HelloRequest();
        request.setName("namil");
        request.setAge(20);

        User savedUser = helloService.saveUser(request);

        //when
        UserResponse response = helloService.getUserById(savedUser.getId());

        assertThat(response.getName()).isEqualTo("namil");
        assertThat(response.getAge()).isEqualTo(20);
    }

    @Test
    void 유저_수정_테스트() {

        //given
        HelloRequest saveReqeust = new HelloRequest();
        saveReqeust.setName("namil");
        saveReqeust.setAge(20);

        User savedUser = helloService.saveUser(saveReqeust);

        HelloRequest updateRequest = new HelloRequest();
        updateRequest.setName("kim");
        updateRequest.setAge(30);

        //when
        UserResponse response = helloService.updateUser(savedUser.getId(), updateRequest);

        //then
        assertThat(response.getId()).isEqualTo(savedUser.getId());
        assertThat(response.getName()).isEqualTo("kim");
        assertThat(response.getAge()).isEqualTo(30);
    }

    @Test
    void 유저_삭제_테스트() {

        //given
        HelloRequest request = new HelloRequest();
        request.setName("namil");
        request.setAge(20);

        User savedUser = helloService.saveUser(request);

        //when
        helloService.deleteUser(savedUser.getId());

        //then
        assertThatThrownBy(() -> helloService.getUserById(savedUser.getId())).isInstanceOf(RuntimeException.class);
    }
}
