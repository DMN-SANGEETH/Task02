package com.entgra.Task02.dao;

import com.entgra.Task02.dto.IssueDto;
import com.entgra.Task02.dto.request.IssueUpdateRequestDto;
import com.entgra.Task02.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface IssueRepo extends JpaRepository<Issue, Integer> {
//    @Query("SELECT new com.entgra.Task02.dto.response.IssueResponseDto(i.issueId , i.)")
}
