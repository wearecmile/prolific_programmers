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
@Table(name = "user_fcm_token")
public class UserFcmToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uft_id")
    private Long uftId;

    @Column(name = "uft_user_id")
    private Long uftUserId;

    @Column(name = "uft_device_type")
    private String uftDeviceType;

    @Column(name = "uft_fcm_token")
    private String uftFcmToken;

    @Column(name = "uft_uid")
    private String uftUid;

    @Column(name = "uft_is_active")
    private Boolean uftIsActive = Boolean.TRUE;

    @CreationTimestamp
    @Column(name = "uft_created_date_time", nullable = false, updatable = false)
    private Date uftCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "uft_updated_date_time")
    private Date uftUpdatedDateTime = new Date();

    @ManyToOne
    @JoinColumn(name = "uft_user_id", insertable = false, updatable = false)
    private User user;
}
