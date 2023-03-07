package com.entgra.Task02.dao;

import com.entgra.Task02.model.Issue;
import com.entgra.Task02.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {
    //User findByUserId(int userId);
}
