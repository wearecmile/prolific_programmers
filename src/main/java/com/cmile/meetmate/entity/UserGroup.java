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
@Table(name = "user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ug_id")
    private Long userGroupId;

    @Column(name = "ug_group_id")
    private Long ugGroupId;

    @Column(name = "user_id")
    private Long ugUserId;

    @CreationTimestamp
    @Column(name = "ug_created_date_time", nullable = false, updatable = false)
    private Date ugCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "ug_updated_date_time")
    private Date ugUpdatedDateTime = new Date();
}
