package com.entgra.Task02.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter

public class IssueStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private  @NonNull int statusId;
    @Column(name = "status")
    private  String status;

    @OneToMany(mappedBy = "issueStatus")
    private List<Issue> issues = new ArrayList<>();
}
