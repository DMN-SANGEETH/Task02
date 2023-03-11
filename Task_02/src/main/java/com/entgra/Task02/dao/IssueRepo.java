package com.entgra.Task02.dao;

import com.entgra.Task02.dto.IssueDto;
import com.entgra.Task02.dto.request.IssueUpdateRequestDto;
import com.entgra.Task02.model.AllHistory;
import com.entgra.Task02.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface IssueRepo extends JpaRepository<Issue, Integer> {
//    @Query(value = "SELECT * FROM issue WHERE issue.status_id = 1", nativeQuery = true)
//    int countByStatus1();
//
//    @Query(value = "SELECT COUNT(status_id) FROM issue WHERE issue.status_id = 2", nativeQuery = true)
//    int countByStatus2();
//
//    @Query(value = "SELECT COUNT(status_id) FROM issue WHERE issue.status_id = 3", nativeQuery = true)
//    int countByStatus3();
//
//    @Query(value = "SELECT COUNT(status_id) FROM issue WHERE issue.status_id = 4", nativeQuery = true)
//    int countByStatus4();
}
