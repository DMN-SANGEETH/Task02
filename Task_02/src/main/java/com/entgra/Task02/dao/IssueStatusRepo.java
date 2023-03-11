package com.entgra.Task02.dao;

import com.entgra.Task02.model.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@EnableJpaRepositories
public interface IssueStatusRepo extends JpaRepository<IssueStatus, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE IssueStatus s SET s.count = (SELECT COUNT(i) FROM Issue i WHERE i.issueStatus = s)")
    void updateCounts();

}
