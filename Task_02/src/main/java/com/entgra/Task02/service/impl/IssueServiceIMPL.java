package com.entgra.Task02.service.impl;

import com.entgra.Task02.dao.*;
import com.entgra.Task02.dto.mapper;
import com.entgra.Task02.dto.request.IssueRequestDto;
import com.entgra.Task02.dto.request.IssueUpdateRequestDto;
import com.entgra.Task02.model.*;
import org.modelmapper.ModelMapper;
import com.entgra.Task02.dto.response.IssueResponseDto;
import com.entgra.Task02.service.IssueService;
import lombok.Data;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class IssueServiceIMPL implements IssueService {
    private final IssueRepo issueRepo;
    private final ModelMapper modelMapper;
    private final IssueStatusRepo issueStatusRepo;
    private final IssueTypeRepo issueTypeRepo;
    private final UserRepo userRepo;
    private final AllHistoryRepo allHistoryRepo;

    public IssueServiceIMPL(IssueRepo issueRepo,ModelMapper modelMapper, IssueStatusRepo issueStatusRepo, IssueTypeRepo issueTypeRepo, UserRepo userRepo, AllHistoryRepo allHistoryRepo) {
        this.issueRepo = issueRepo;
        this.modelMapper = modelMapper;
        this.issueStatusRepo = issueStatusRepo;
        this.issueTypeRepo = issueTypeRepo;
        this.userRepo = userRepo;
        this.allHistoryRepo = allHistoryRepo;
    }

    @Override
    public List<IssueResponseDto> allIssues() {
        List<Issue> issues = new ArrayList<>(issueRepo.findAll());
        issueStatusRepo.updateCounts();
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
        Issue savedIssue = issueRepo.save(issue);

        AllHistory history = new AllHistory();
        history.setIssueId(savedIssue);
        history.setProjectName(savedIssue.getProjectName());
        history.setSubject(savedIssue.getSubject());
        history.setDescription(savedIssue.getDescription());
        history.setPublicationDate(savedIssue.getPublicationDate());
        history.setIssueType(savedIssue.getIssueType());
        history.setIssueStatus(savedIssue.getIssueStatus());
        history.setUser(savedIssue.getUser());
        allHistoryRepo.save(history);
        return issue;
    }

    @Override
    public Issue updateState(int issueId, IssueUpdateRequestDto issueUpdateRequestDto) {
        Issue issue = issueRepo.findById(issueId).get();
        IssueStatus issueStatus = issueStatusRepo.findById(issueUpdateRequestDto.getStatusId()).get();
        issue.setIssueStatus(issueStatus);
        issue.setPublicationDate(issue.getPublicationDate());
        Issue savedIssue = issueRepo.save(issue);
        AllHistory history = new AllHistory();
        history.setIssueId(savedIssue);
        history.setProjectName(savedIssue.getProjectName());
        history.setSubject(savedIssue.getSubject());
        history.setDescription(savedIssue.getDescription());
        history.setPublicationDate(savedIssue.getPublicationDate());
        history.setIssueType(savedIssue.getIssueType());
        history.setIssueStatus(savedIssue.getIssueStatus());
        history.setUser(savedIssue.getUser());
        allHistoryRepo.save(history);
        return issue;
    }

    @Override
    public List<IssueResponseDto> issuesStatusById(int statusId) {
        List<Issue> issues = new ArrayList<>(issueRepo.findAllByIssueStatusAndIssueStatusContains(statusId));
        return modelMapper.map(issues, new TypeToken<List<IssueResponseDto>>(){}.getType());
    }
}