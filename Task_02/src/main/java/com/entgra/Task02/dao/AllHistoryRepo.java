package com.entgra.Task02.dao;

import com.entgra.Task02.model.AllHistory;
import com.entgra.Task02.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface AllHistoryRepo extends JpaRepository<AllHistory, Integer> {
    @Query(value = "SELECT * FROM all_history WHERE all_history.issue_id = :issue_id", nativeQuery = true)
    List<AllHistory> findAllHistoriesByIssueId(
            @Param("issue_id") int issueId);
}
