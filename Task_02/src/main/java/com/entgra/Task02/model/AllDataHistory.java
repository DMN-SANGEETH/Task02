package com.entgra.Task02.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@DynamicInsert
@DynamicUpdate
public class AllDataHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private  @NonNull int issueId;
    @Column(name = "project_name")
    private  String projectName;
    @Column(name = "subject")
    private  String subject;
    @Column(name = "description")
    private  String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "publication_date")
    private Date publicationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "states_id")
    private  IssueStatus issueStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_tyep_id")
    private  IssueType issueType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private  User user;
}
