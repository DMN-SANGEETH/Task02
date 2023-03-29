package com.entgra.Task02.service;

import com.entgra.Task02.dto.IssueDto;
import com.entgra.Task02.dto.request.IssueRequestDto;
import com.entgra.Task02.dto.request.IssueUpdateRequestDto;
import com.entgra.Task02.dto.response.AllHistoryResponseDto;
import com.entgra.Task02.dto.response.IssueResponseDto;
import com.entgra.Task02.model.Issue;

import java.util.List;

public interface IssueService {
    List<IssueResponseDto> allIssues();
    Issue saveissue(IssueRequestDto issueRequestDto);
    Issue updateState(int issueId, IssueUpdateRequestDto issueUpdateRequestDto);
    List<IssueResponseDto> issuesStatusById(int statusId);
}
