package com.entgra.Task02.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@DynamicInsert
@DynamicUpdate

public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private int issueId;
    @Column(name = "project_name")
    private  String projectName;
    @Column(name = "subject")
    private  String subject;
    @Column(name = "description")
    private  String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "publication_date")
    private  Date publicationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    @JsonIgnore
    private  IssueStatus issueStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "issue_type_id")
    @JsonIgnore
    private  IssueType issueType;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private  User user;
    @OneToMany(mappedBy = "issueId")
    private List<AllHistory> allHistories = new ArrayList<>();

}
