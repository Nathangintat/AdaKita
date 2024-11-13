package com.springboot.adakita.adakita.repository;

import com.springboot.adakita.adakita.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Interface
public interface UserRepository
        extends JpaRepository<User, Integer> {
}
