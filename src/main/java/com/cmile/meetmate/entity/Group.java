package com.cmile.meetmate.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "groups")
@SQLDelete(sql = "update groups set group_is_active = false where group_id = ?")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_description")
    private String groupDescription;

    @Column(name = "group_is_active")
    private Boolean groupIsActive;

    @Column(name = "group_created_by")
    private Long groupCreatedBy;

    @CreationTimestamp
    @Column(name = "group_created_date_time", nullable = false, updatable = false)
    private Date groupCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "group_updated_date_time")
    private Date groupUpdatedDateTime = new Date();

    @OneToOne
    @JoinColumn(name = "group_created_by", insertable = false, updatable = false)
    private User user;
}
