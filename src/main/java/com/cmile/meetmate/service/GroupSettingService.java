package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.GroupSettings;
import org.springframework.http.ResponseEntity;

public interface GroupSettingService {
    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long groupSettingsId);

    ResponseEntity<Object> save(GroupSettings groupSettings);

    ResponseEntity<Object> update(GroupSettings groupSettings);

    ResponseEntity<Object> delete(Long groupSettingsId);
}
