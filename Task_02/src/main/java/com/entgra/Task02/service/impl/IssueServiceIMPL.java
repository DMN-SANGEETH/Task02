package com.entgra.Task02.service.impl;

import com.entgra.Task02.dao.*;
import com.entgra.Task02.dto.IssueDto;
import com.entgra.Task02.dto.IssueTypeDto;
import com.entgra.Task02.dto.mapper;
import com.entgra.Task02.dto.request.IssueRequestDto;
import com.entgra.Task02.dto.request.IssueUpdateRequestDto;
import com.entgra.Task02.model.*;
import org.modelmapper.ModelMapper;
import com.entgra.Task02.dto.response.IssueResponseDto;
import com.entgra.Task02.service.IssueService;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class IssueServiceIMPL implements IssueService {
    private final IssueRepo issueRepo;
    private final ModelMapper modelMapper;
    private final IssueStatusRepo issueStatusRepo;
    private final IssueTypeRepo issueTypeRepo;
    private final UserRepo userRepo;
//    private final AllDataHistoryRepo allDataHistoryRepo;

    public IssueServiceIMPL(IssueRepo issueRepo,ModelMapper modelMapper, IssueStatusRepo issueStatusRepo, IssueTypeRepo issueTypeRepo, UserRepo userRepo) {
        this.issueRepo = issueRepo;
        this.modelMapper = modelMapper;
        this.issueStatusRepo = issueStatusRepo;
        this.issueTypeRepo = issueTypeRepo;
        this.userRepo = userRepo;
//        this.allDataHistoryRepo = allDataHistoryRepo;
    }

    @Override
    public List<IssueResponseDto> allIssues() {
        List<Issue> issues = new ArrayList<>(issueRepo.findAll());
        return mapper.issueToIssueLists(issues);
    }

    @Override
    public Issue saveissue(IssueRequestDto issueRequestDto) {
        Issue issue = new Issue();
        issue.setProjectName(issueRequestDto.getProjectName());
        issue.setSubject(issueRequestDto.getSubject());
        issue.setDescription(issueRequestDto.getDescription());
        issue.setPublicationDate(issueRequestDto.getPublicationDate());



//        Issue issue = modelMapper.map(issueRequestDto, Issue.class);

        issue.setIssueType(issueTypeRepo.findById(issueRequestDto.getIssueTypeId()).get());
        issue.setIssueStatus(issueStatusRepo.findById(issueRequestDto.getStatusId()).get());
        issue.setUser(userRepo.findById(issueRequestDto.getUserId()).get());
        return issueRepo.save(issue);


//        AllDataHistory history = new AllDataHistory();
//        history.setIssue(issueRepo.findById(issueRequestDto.getIssueId()).get());
//        history.setProjectName(issue.getProjectName());
//        history.setSubject(issue.getSubject());
//        history.setDescription(issue.getDescription());
//        history.setPublicationDate(issue.getPublicationDate());
//        history.setIssueType(issue.getIssueType());
//        history.setIssueStatus(issue.getIssueStatus());
//        history.setUser(issue.getUser());
//        allDataHistoryRepo.save(history);

//        return issue;

    }

    @Override
    public Issue updateState(int issueId, IssueUpdateRequestDto issueUpdateRequestDto) {
        Issue issue = issueRepo.findById(issueId).get();
        IssueStatus issueStatus = issueStatusRepo.findById(issueUpdateRequestDto.getStatusId()).get();
        issue.setIssueStatus(issueStatus);
        return issueRepo.save(issue);
    }


}