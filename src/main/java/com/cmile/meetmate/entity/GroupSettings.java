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
@Table(name = "group_settings")
public class GroupSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gs_id")
    private Long gsId;

    @Column(name = "gs_group_id", unique = true)
    private Long gsGroupId;

    @Column(name = "gs_captain_will_pay")
    private Boolean gsCaptainWillPay = Boolean.FALSE;

    @Column(name = "gs_absentee_will_pay")
    private Boolean gsAbsenteeWillPay = Boolean.FALSE;

    @CreationTimestamp
    @Column(name = "gs_created_date_time", nullable = false, updatable = false)
    private Date gsCreatedDateTime = new Date();

    @UpdateTimestamp
    @Column(name = "gs_updated_date_time")
    private Date gsUpdatedDateTime = new Date();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gs_group_id", insertable = false, updatable = false)
    private Group group;
}
