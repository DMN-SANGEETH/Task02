package com.entgra.Task02.dao;

import com.entgra.Task02.model.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface IssueStatusRepo extends JpaRepository<IssueStatus, Integer> {
    //IssueStatus findByStatusId(int statusId);
  //  IssueStatus getById(int issueTypeId);
}
