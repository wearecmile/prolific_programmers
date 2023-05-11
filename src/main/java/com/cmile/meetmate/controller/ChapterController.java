package com.cmile.meetmate.controller;

import com.cmile.meetmate.entity.Chapter;
import com.cmile.meetmate.service.ChapterService;
import com.cmile.meetmate.utils.constant.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstant.REQUEST_MAPPING_KEY_CHAPTER)
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return chapterService.findAll();
    }

    @GetMapping(ApiConstant.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return chapterService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Chapter chapter) {
        return chapterService.save(chapter);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Chapter chapter) {
        return chapterService.update(chapter);
    }

    @DeleteMapping(ApiConstant.REQUEST_MAPPING_KEY_ID)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return chapterService.delete(id);
    }
}
