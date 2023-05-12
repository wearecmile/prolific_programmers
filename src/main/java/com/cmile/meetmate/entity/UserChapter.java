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
@Table(name = "user_chapter")
public class UserChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uc_id")
    private Long ucId;

    @Column(name = "uc_user_id")
    private Long ucUserId;

    @Column(name = "uc_chapter_id")
    private Long ucChapterId;

    @CreationTimestamp
    @Column(name = "uc_created_date_time", nullable = false, updatable = false)
    private Date ucCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "uc_updated_date_time")
    private Date ucUpdatedDateTime = new Date();

    @ManyToOne
    @JoinColumn(name = "uc_user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "uc_chapter_id", insertable = false, updatable = false)
    private Chapter chapter;
}
