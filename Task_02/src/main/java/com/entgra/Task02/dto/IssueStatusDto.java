package com.entgra.Task02.dto;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class IssueStatusDto {
    private  @NonNull int statusId;
    private  String status;
}
