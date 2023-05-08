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
@Table(name = "payment_history")
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ph_id")
    private Long phId;

    @Column(name = "ph_user_id")
    private Long phUserId;

    @Column(name = "ph_note")
    private String phNote;

    @Column(name = "ph_amount")
    private String phAmount;

    @Column(name = "ph_date")
    private Date phDate;

    @Column(name = "ph_time")
    private String phTime;

    @CreationTimestamp
    @Column(name = "ph_created_date_time", nullable = false, updatable = false)
    private Date phCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "ph_updated_date_time")
    private Date phUpdatedDateTime = new Date();

    @ManyToOne
    @JoinColumn(name = "ph_user_id", insertable = false, updatable = false)
    private User user;
}
