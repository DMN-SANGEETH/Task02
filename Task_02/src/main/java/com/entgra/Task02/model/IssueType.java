package com.entgra.Task02.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class IssueType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_type_id")
    @NonNull
    private int issueTypeId;
    @Column(name = "issue_type_name")
    private String issueTypeName;

    @OneToMany(mappedBy = "issueType")
    private List<Issue> issues = new ArrayList<>();


}
