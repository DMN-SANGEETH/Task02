package com.entgra.Task02.dto.response;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class IssueStatusResponseDto {
    private  int statusId;
    private  String status;
    private  int count;
}
