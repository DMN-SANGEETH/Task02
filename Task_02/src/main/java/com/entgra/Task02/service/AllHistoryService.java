package com.entgra.Task02.service;

import com.entgra.Task02.dto.response.AllHistoryResponseDto;

import java.util.List;

public interface AllHistoryService {
    List<AllHistoryResponseDto> issueById(int issueId);
}
