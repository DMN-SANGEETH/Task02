package com.entgra.Task02.service.impl;

import com.entgra.Task02.dao.*;
import com.entgra.Task02.dto.response.AllHistoryResponseDto;
import com.entgra.Task02.model.AllHistory;
import com.entgra.Task02.service.AllHistoryService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Data
public class
AllHistoryServiceIMPL implements AllHistoryService {
    private final IssueRepo issueRepo;
    private final ModelMapper modelMapper;
    private final IssueStatusRepo issueStatusRepo;
    private final IssueTypeRepo issueTypeRepo;
    private final UserRepo userRepo;
    private final AllHistoryRepo allHistoryRepo;

    public AllHistoryServiceIMPL(IssueRepo issueRepo, ModelMapper modelMapper, IssueStatusRepo issueStatusRepo, IssueTypeRepo issueTypeRepo, UserRepo userRepo, AllHistoryRepo allHistoryRepo) {
        this.issueRepo = issueRepo;
        this.modelMapper = modelMapper;
        this.issueStatusRepo = issueStatusRepo;
        this.issueTypeRepo = issueTypeRepo;
        this.userRepo = userRepo;
        this.allHistoryRepo = allHistoryRepo;
    }

    @Override
    public List<AllHistoryResponseDto> issueById(int issueId) {
        List<AllHistory> allHistories = allHistoryRepo.findAllHistoriesByIssueId(issueId);
        return modelMapper.map(allHistories, new TypeToken<List<AllHistoryResponseDto>>(){}.getType());
    }
    }