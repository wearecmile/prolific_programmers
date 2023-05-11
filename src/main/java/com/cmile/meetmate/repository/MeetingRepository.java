package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findAllMeetingIdByMeetingChapterId(Long meetingId);

}
