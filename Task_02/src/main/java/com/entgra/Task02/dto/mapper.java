package com.entgra.Task02.dto;

import com.entgra.Task02.dto.request.IssueRequestDto;
import com.entgra.Task02.dto.response.IssueResponseDto;
import com.entgra.Task02.model.Issue;
import com.entgra.Task02.model.IssueStatus;
import com.entgra.Task02.model.IssueType;
import com.entgra.Task02.model.User;

import java.util.ArrayList;
import java.util.List;

public class mapper {
    public static List<IssueResponseDto> issueToIssueLists(List<Issue> issues) {
        List<IssueResponseDto> issueResponseDtos = new ArrayList<>();
        for (Issue issued : issues) {
            issueResponseDtos.add(issueToIssueList(issued));
        }
        return issueResponseDtos;
    }

    public static IssueResponseDto issueToIssueList(Issue issue) {
        IssueResponseDto issueResponseDto = new IssueResponseDto();
        issueResponseDto.setIssueId(issue.getIssueId());
        issueResponseDto.setProjectName(issue.getProjectName());
        issueResponseDto.setSubject(issue.getSubject());
        issueResponseDto.setDescription(issue.getDescription());
        issueResponseDto.setPublicationDate(issue.getPublicationDate());

        IssueTypeDto issueTypeDto = new IssueTypeDto();
        IssueType issueType = issue.getIssueType();
        issueTypeDto.setIssueTypeId(issueType.getIssueTypeId());
        issueTypeDto.setIssueTypeName(issueType.getIssueTypeName());

        issueResponseDto.setIssueType(issueTypeDto);

        IssueStatusDto issueStatusDto = new IssueStatusDto();
        IssueStatus issueStatus = issue.getIssueStatus();
        issueStatusDto.setStatusId(issueStatus.getStatusId());
        issueStatusDto.setStatus(issueStatus.getStatus());

        issueResponseDto.setIssueStatus(issueStatusDto);

        UserDto userDto = new UserDto();
        User users = issue.getUser();
        userDto.setUserId(users.getUserId());
        userDto.setUserName(users.getUserName());
        userDto.setPassword(users.getPassword());

        issueResponseDto.setUser(userDto);
        return issueResponseDto;
    }
}