package com.entgra.Task02.dto.response;

import com.entgra.Task02.dto.IssueStatusDto;
import com.entgra.Task02.dto.IssueTypeDto;
import com.entgra.Task02.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class AllHistoryResponseDto {
    private int id;
    private int issueId;
    private  String projectName;
    private  String subject;
    private  String description;
    private Date publicationDate;
    private IssueStatusDto issueStatus;
    private IssueTypeDto issueType;
    private UserDto user;
}
