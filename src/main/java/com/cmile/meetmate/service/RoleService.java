package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.Role;
import org.springframework.http.ResponseEntity;

public interface RoleService {

    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long roleId);

    ResponseEntity<Object> save(Role role);

    ResponseEntity<Object> update(Role role);

    ResponseEntity<Object> delete(Long roleId);
}
