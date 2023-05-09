package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.service.UserService;
import com.cmile.meetmate.utils.constant.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstant.REQUEST_MAPPING_KEY_USER)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return userService.findAll();
    }

    @GetMapping(ApiConstant.REQUEST_MAPPING_USER_ID)
    public ResponseEntity<Object> findById(@PathVariable Long userId){return userService.findById(userId);}

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody User user){return userService.save(user);}

    @PutMapping(ApiConstant.REQUEST_MAPPING_USER_ID)
    public ResponseEntity<Object> update(@RequestBody User user){return userService.update(user);}

    @DeleteMapping(ApiConstant.REQUEST_MAPPING_USER_ID)
    public ResponseEntity<Object>delete(@PathVariable Long userId){return userService.delete(userId);}

}
