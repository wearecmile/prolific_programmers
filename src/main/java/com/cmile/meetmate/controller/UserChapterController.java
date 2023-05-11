package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.UserChapter;
import com.cmile.meetmate.service.UserChapterService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstants.REQUEST_MAPPING_KEY_USER_CHAPTER)
public class UserChapterController {
    @Autowired
    UserChapterService userChapterService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UserChapter userChapter) {
        return userChapterService.save(userChapter);
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return userChapterService.findAll();
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return userChapterService.findById(id);
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_FIND_USER_BY_CHAPTER)
    public ResponseEntity<Object> findAllUcUserId(@PathVariable Long id) {
        return userChapterService.findAllUcUserId(id);
    }

    @GetMapping(value = ApiConstants.REQUEST_MAPPING_KEY_FIND_CHAPTER_BY_USER)
    public ResponseEntity<Object> findAllUcChapterId(@PathVariable Long id) {
        return userChapterService.findAllUcChapterId(id);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UserChapter userChapter) {
        return userChapterService.update(userChapter);
    }

    @DeleteMapping(ApiConstants.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return userChapterService.delete(id);
    }
}
