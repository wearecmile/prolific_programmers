package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.Meeting;
import com.cmile.meetmate.service.MeetingService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstants.REQUEST_MAPPING_KEY_MEETING)
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Meeting meeting){
        return meetingService.save(meeting);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return meetingService.findAll();
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id){
        return meetingService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Meeting meeting){
        return meetingService.update(meeting);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return meetingService.delete(id);
    }
}
