package com.entgra.Task02.dto.response;

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
public class AllDataHistoryRequestDto {
    private  @NonNull int issueId;
    private  String projectName;
    private int issueTypeId;
    private  String subject;
    private  String description;
    private int statusId;
    private int userId;
    private Date publicationDate;
}
