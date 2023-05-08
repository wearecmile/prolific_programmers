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

    @Column(name = "user_contact")
    private String userContact;

    @Column(name = "user_role")
    private Long userRole;

    @Column(name = "user_opening_balance")
    private String userOpeningBalance;

    @Column(name = "user_closing_balance")
    private String userClosingBalance;

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
