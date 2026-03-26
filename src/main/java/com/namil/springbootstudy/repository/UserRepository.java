package com.namil.springbootstudy.repository;

import com.namil.springbootstudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
