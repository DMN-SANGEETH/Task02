package com.entgra.Task02.dto;

import com.entgra.Task02.model.IssueStatus;
import com.entgra.Task02.model.IssueType;
import com.entgra.Task02.model.User;
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
public class IssueDto {
    private int issueId;
    private  String projectName;
    private  String subject;
    private  String description;
    private Date publicationDate;
    private IssueStatus issueStatus;
    private IssueType issueType;
    private User user;
}
