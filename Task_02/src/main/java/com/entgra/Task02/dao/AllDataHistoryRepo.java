package com.entgra.Task02.dao;

import com.entgra.Task02.model.AllDataHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AllDataHistoryRepo extends JpaRepository<AllDataHistory, Integer> {
}
