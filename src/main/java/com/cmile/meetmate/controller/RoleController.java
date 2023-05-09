package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.Role;
import com.cmile.meetmate.service.RoleService;
import com.cmile.meetmate.utils.constant.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstant.REQUEST_MAPPING_KEY_ROLE)
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return roleService.findAll();
    }

    @GetMapping(ApiConstant.REQUEST_MAPPING_ROLE_ID)
    public ResponseEntity<Object> findById(@PathVariable Long roleId){return roleService.findById(roleId);}

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Role role){return roleService.save(role);}

    @PutMapping(ApiConstant.REQUEST_MAPPING_ROLE_ID)
    public ResponseEntity<Object> update(@RequestBody Role role){return roleService.update(role);}

    @DeleteMapping(ApiConstant.REQUEST_MAPPING_ROLE_ID)
    public ResponseEntity<Object>delete(@PathVariable Long roleId){return roleService.delete(roleId);}
}
