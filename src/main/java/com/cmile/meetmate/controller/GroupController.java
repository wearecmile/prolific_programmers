package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.Group;
import com.cmile.meetmate.service.GroupService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstants.REQUEST_MAPPING_KEY_GROUP)
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return groupService.findAll();
    }

    @GetMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return groupService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Group group) {
        return groupService.save(group);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Group group) {
        return groupService.update(group);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return groupService.delete(id);
    }
}
