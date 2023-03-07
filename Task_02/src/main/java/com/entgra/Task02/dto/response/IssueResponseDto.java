package com.entgra.Task02.dto.response;

import com.entgra.Task02.dto.IssueStatusDto;
import com.entgra.Task02.dto.IssueTypeDto;
import com.entgra.Task02.dto.UserDto;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class IssueResponseDto {
    private int issueId;
    private String projectName;
    private IssueTypeDto issueType; // --> Tracker
    private IssueStatusDto issueStatus;
    private String subject;
    private UserDto user;
    private String description;
    private Date publicationDate;

}
