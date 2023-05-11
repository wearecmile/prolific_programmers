package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long userId);

    ResponseEntity<Object> save(User user);

    ResponseEntity<Object> update(User user);

    ResponseEntity<Object> delete(Long userId);

    ResponseEntity<Object> findAllByUserRole(Long userRole);
}
