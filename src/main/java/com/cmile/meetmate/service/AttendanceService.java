package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.Attendance;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface AttendanceService {

    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long attendanceId);

    ResponseEntity<Object> save(Attendance attendance);

    ResponseEntity<Object> saveMultiple(List<Attendance> attendance);

    ResponseEntity<Object> update(Attendance attendance);

    ResponseEntity<Object> delete(Long attendanceId);

    ResponseEntity<Object> findAllAttendanceByMeeting(Long meetingId);

    ResponseEntity<Object> getAllVisitorByMeeting(Long meetingId);

}
