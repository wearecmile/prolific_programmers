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
@Table(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private Long chapterId;

    @Column(name = "chapter_name")
    private String chapterName;

    @CreationTimestamp
    @Column(name = "chapter_created_date_time", nullable = false, updatable = false)
    private Date chapterCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "chapter_updated_date_time")
    private Date chapterUpdatedDateTime = new Date();
}
