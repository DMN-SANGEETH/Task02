package com.entgra.Task02.service;

import com.entgra.Task02.dto.response.IssueStatusResponseDto;

import java.util.List;

public interface IssueStatusService {
    List<IssueStatusResponseDto> issueStatus();
}
