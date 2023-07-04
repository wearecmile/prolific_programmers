package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.UserGroup;
import org.springframework.http.ResponseEntity;

public interface UserGroupService {
    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long ugId);

    ResponseEntity<Object> save(UserGroup userGroup);

    ResponseEntity<Object> update(UserGroup userGroup);

    ResponseEntity<Object> delete(Long ugId);

    ResponseEntity<Object> findGroupsByUserId(Long userId);

    ResponseEntity<Object> findGroupMembers(Long groupId);
}
