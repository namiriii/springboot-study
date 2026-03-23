package com.namil.springbootstudy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public class HelloRequest {

    @NotBlank
    private String name;

    @NotNull
    @Min(1)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void validate() {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name이 비어 있습니다.");
        }

        if (age == null || age <= 0) {
            throw new IllegalArgumentException("age는 1 이상이어야 합니다.");
        }
    }
}
