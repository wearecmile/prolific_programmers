package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.Attendance;
import com.cmile.meetmate.service.AttendanceService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstants.REQUEST_MAPPING_KEY_ATTENDANCE)
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Attendance attendance) {
        return attendanceService.save(attendance);
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return attendanceService.findAll();
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return attendanceService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Attendance attendance) {
        return attendanceService.update(attendance);
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_FIND_ATTENDANCE_BY_MEETING_USER_ID)
    public ResponseEntity<Object> findAllAttendanceByMeeting(@PathVariable Long id) {
        return attendanceService.findAllAttendanceByMeeting(id);
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_FIND_ALL_VISITORS_BY_MEETING)
    public ResponseEntity<Object> getAllVisitorByMeeting(@PathVariable Long id) {
        return attendanceService.getAllVisitorByMeeting(id);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return attendanceService.delete(id);
    }
}
