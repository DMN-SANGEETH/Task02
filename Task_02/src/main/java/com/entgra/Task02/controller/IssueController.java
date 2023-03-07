package com.entgra.Task02.controller;
import com.entgra.Task02.dto.IssueDto;
import com.entgra.Task02.dto.request.IssueRequestDto;
import com.entgra.Task02.dto.request.IssueUpdateRequestDto;
import com.entgra.Task02.dto.response.IssueResponseDto;
import com.entgra.Task02.model.Issue;
import com.entgra.Task02.service.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/v1/issue")
public class IssueController {
    public final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping()
    public List<IssueResponseDto> allIssues() {
        return issueService.allIssues();
    }

    @PostMapping("/add-issue")
    public Issue saveissue(@RequestBody IssueRequestDto issueRequestDto) {
        return issueService.saveissue(issueRequestDto);
    }

    @PutMapping("/State-change/{id}")
    public Issue updateState(@PathVariable(value = "id") int issueId, @RequestBody IssueUpdateRequestDto issueUpdateRequestDto) {
        return issueService.updateState(issueId, issueUpdateRequestDto);
    }
}
