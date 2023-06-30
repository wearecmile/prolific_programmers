package com.cmile.meetmate.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
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
@Table(name = "group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_description")
    private String groupDescription;

    @CreationTimestamp
    @Column(name = "group_created_date_time", nullable = false, updatable = false)
    private Date groupCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "group_updated_date_time")
    private Date groupUpdatedDateTime = new Date();
}
