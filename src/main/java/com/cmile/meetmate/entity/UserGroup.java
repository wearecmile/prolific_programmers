package com.cmile.meetmate.entity;

import com.cmile.meetmate.enums.RoleEnum;
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
@SQLDelete(sql = "update user_group set ug_is_active = false where ug_id = ?")
@Table(name = "user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ug_id")
    private Long ugId;

    @Column(name = "ug_group_id")
    private Long ugGroupId;

    @Column(name = "ug_user_id")
    private Long ugUserId;

    @Column(name = "ug_role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum ugRoleName;

    @Column(name = "ug_is_active")
    private Boolean ugIsActive;

    @CreationTimestamp
    @Column(name = "ug_created_date_time", nullable = false, updatable = false)
    private Date ugCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "ug_updated_date_time")
    private Date ugUpdatedDateTime = new Date();

    @ManyToOne
    @JoinColumn(name = "ug_group_id", insertable = false, updatable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "ug_user_id", insertable = false, updatable = false)
    private User user;
}
