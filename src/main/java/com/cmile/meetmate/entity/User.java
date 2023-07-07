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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_contact", unique = true)
    private String userContact;

    @Column(name = "user_role")
    private Long userRole;

    @CreationTimestamp
    @Column(name = "user_created_date_time", nullable = false, updatable = false)
    private Date userCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "user_updated_date_time")
    private Date userUpdatedDateTime = new Date();

    @ManyToOne
    @JoinColumn(name = "user_role", insertable = false, updatable = false)
    private Role role;
}
