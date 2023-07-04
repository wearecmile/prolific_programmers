package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.UserGroup;
import com.cmile.meetmate.enums.RoleEnum;
import org.springframework.http.ResponseEntity;

public interface UserGroupService {
    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long ugId);

    ResponseEntity<Object> save(UserGroup userGroup);

    ResponseEntity<Object> update(UserGroup userGroup);

    ResponseEntity<Object> delete(Long ugId);

    ResponseEntity<Object> findGroupsByUserId(Long userId);

    ResponseEntity<Object> findGroupMembers(Long groupId);

//    ResponseEntity<Object> findAllByUser(Long userId);
//
//    ResponseEntity<Object> findAllByGroup(Long groupId);

    ResponseEntity<Object> findByGroupAndRole(Long groupId, RoleEnum roleName);

    ResponseEntity<Object> makeCaptain(UserGroup userGroup);
}
