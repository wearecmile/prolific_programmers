package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.Group;
import org.springframework.http.ResponseEntity;

public interface GroupService {
    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long groupId);

    ResponseEntity<Object> save(Group group);

    ResponseEntity<Object> update(Group group);

    ResponseEntity<Object> delete(Long groupId);
}
