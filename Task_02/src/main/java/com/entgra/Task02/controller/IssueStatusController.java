package com.entgra.Task02.controller;

import com.entgra.Task02.dto.response.IssueStatusResponseDto;
import com.entgra.Task02.service.IssueStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/status")
public class IssueStatusController {

    public final IssueStatusService issueStatusService;

    public IssueStatusController(IssueStatusService issueStatusService) {
        this.issueStatusService = issueStatusService;
    }

    @GetMapping()
    public List<IssueStatusResponseDto> issueStatus (){
        return issueStatusService.issueStatus();
    }

}
