package com.cmile.meetmate.entity;

import com.cmile.meetmate.enums.RoleEnum;
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
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleName;

    @CreationTimestamp
    @Column(name = "role_created_date_time", nullable = false, updatable = false)
    private Date roleCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "role_updated_date_time")
    private Date roleUpdatedDateTime = new Date();
}
