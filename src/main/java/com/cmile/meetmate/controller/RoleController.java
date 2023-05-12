package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.Role;
import com.cmile.meetmate.service.RoleService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstants.REQUEST_MAPPING_KEY_ROLE)
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return roleService.findAll();
    }

    @GetMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return roleService.delete(id);
    }
}
