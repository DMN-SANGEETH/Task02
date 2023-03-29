package com.entgra.Task02.service.impl;

import com.entgra.Task02.dao.*;
import com.entgra.Task02.dto.response.IssueStatusResponseDto;
import com.entgra.Task02.model.IssueStatus;
import com.entgra.Task02.service.IssueStatusService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class IssueStatusServiceIMPL implements IssueStatusService {
    private final IssueRepo issueRepo;
    private final ModelMapper modelMapper;
    private final IssueStatusRepo issueStatusRepo;
    private final IssueTypeRepo issueTypeRepo;
    private final UserRepo userRepo;
    private final AllHistoryRepo allHistoryRepo;

    public IssueStatusServiceIMPL(IssueRepo issueRepo,ModelMapper modelMapper, IssueStatusRepo issueStatusRepo, IssueTypeRepo issueTypeRepo, UserRepo userRepo, AllHistoryRepo allHistoryRepo) {
        this.issueRepo = issueRepo;
        this.modelMapper = modelMapper;
        this.issueStatusRepo = issueStatusRepo;
        this.issueTypeRepo = issueTypeRepo;
        this.userRepo = userRepo;
        this.allHistoryRepo = allHistoryRepo;
    }

    @Override
    public List<IssueStatusResponseDto> issueStatus() {
        List<IssueStatus> issueStatus = new ArrayList<>(issueStatusRepo.findAll());
        List<IssueStatusResponseDto> issueStatusResponseDtos = modelMapper.map(issueStatus, new TypeToken<List<IssueStatusResponseDto>>(){}.getType());
        return issueStatusResponseDtos;
    }

}
