package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.Meeting;
import org.springframework.http.ResponseEntity;

public interface MeetingService {

    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long meetingId);

    ResponseEntity<Object> save(Meeting meeting);

    ResponseEntity<Object> update(Meeting meeting);

    ResponseEntity<Object> delete(Long meetingId);

    ResponseEntity<Object> findAllMeetingByChapter(Long meetingId);
}
