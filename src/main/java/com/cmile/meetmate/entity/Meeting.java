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
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id")
    private Long meetingId;

    @Column(name = "meeting_title")
    private String meetingTitle;

    @Column(name = "meeting_note")
    private String meetingNote;

    @Column(name = "meeting_cost")
    private String meetingCost;

    @Column(name = "meeting_date")
    private Date meetingDate;

    @Column(name = "meeting_time")
    private String meetingTime;

    @CreationTimestamp
    @Column(name = "meeting_created_date_time", nullable = false, updatable = false)
    private Date meetingCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "meeting_updated_date_time")
    private Date meetingUpdatedDateTime = new Date();

    @Column(name = "meeting_chapter_id")
    private Long meetingChapterId;

    @ManyToOne
    @JoinColumn(name = "meeting_chapter_id", insertable = false, updatable = false)
    private Chapter chapter;

}
