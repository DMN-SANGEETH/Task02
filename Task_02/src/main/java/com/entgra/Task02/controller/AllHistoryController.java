package com.entgra.Task02.controller;

import com.entgra.Task02.dto.response.AllHistoryResponseDto;
import com.entgra.Task02.model.AllHistory;
import com.entgra.Task02.service.AllHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/v1/history")
public class AllHistoryController {
    public final AllHistoryService allHistoryService;

    public AllHistoryController(AllHistoryService allHistoryService) {
        this.allHistoryService = allHistoryService;
    }

    @GetMapping("/{issueId}")
    public List<AllHistoryResponseDto> issuesById(@PathVariable int issueId){
        return allHistoryService.issueById(issueId);
    }
}
