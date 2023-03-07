package com.entgra.Task02.dto.request;
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
public class IssueRequestDto {
    private  @NonNull int issueId;
    private  String projectName;
    private int issueTypeId;
    private  String subject;
    private  String description;
    private int statusId;
    private int userId;
    private Date publicationDate;
}
