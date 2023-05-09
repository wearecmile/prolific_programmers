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
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @Column(name = "attendance_meeting_id")
    private Long attendanceMeetingId;

    @Column(name = "attendance_user_id")
    private Long attendanceUserId;

    @Column(name = "attendance_is_present")
    private Boolean attendanceIsPresent = Boolean.TRUE;

    @CreationTimestamp
    @Column(name = "attendance_created_date_time", nullable = false, updatable = false)
    private Date attendanceCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "attendance_updated_date_time")
    private Date attendanceUpdatedDateTime = new Date();

    @ManyToOne
    @JoinColumn(name = "attendance_meeting_id", insertable = false, updatable = false)
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name = "attendance_user_id", insertable = false, updatable = false)
    private User user;
}
