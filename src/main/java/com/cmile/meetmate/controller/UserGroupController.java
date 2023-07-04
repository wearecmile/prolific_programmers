package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.UserGroup;
import com.cmile.meetmate.service.UserGroupService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstants.REQUEST_MAPPING_KEY_USER_GROUP)
public class UserGroupController {

    @Autowired
    UserGroupService userGroupService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return userGroupService.findAll();
    }

    @GetMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return userGroupService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UserGroup userGroup) {
        return userGroupService.save(userGroup);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UserGroup userGroup) {
        return userGroupService.update(userGroup);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return userGroupService.delete(id);
    }

    @GetMapping(ApiConstants.REQUEST_MAPPING_KEY_USER_USER_ID)
    public ResponseEntity<Object> findGroupsByUserId(@PathVariable Long userId) {
        return userGroupService.findGroupsByUserId(userId);
    }

    @GetMapping(ApiConstants.REQUEST_MAPPING_KEY_GROUP_GROUP_ID)
    public ResponseEntity<Object> findGroupMembers(@PathVariable Long groupId) {
        return userGroupService.findGroupMembers(groupId);
    }
}
