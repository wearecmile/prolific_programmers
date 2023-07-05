package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.GroupSettings;
import com.cmile.meetmate.service.GroupSettingService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.REQUEST_MAPPING_KEY_GROUP_SETTINGS)
public class GroupSettingsController {

    @Autowired
    GroupSettingService groupSettingService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody GroupSettings groupSettings) {
        return groupSettingService.save(groupSettings);
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return groupSettingService.findAll();
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return groupSettingService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody GroupSettings groupSettings) {
        return groupSettingService.update(groupSettings);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return groupSettingService.delete(id);
    }
}
