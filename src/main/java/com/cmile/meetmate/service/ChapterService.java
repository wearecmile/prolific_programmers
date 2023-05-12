package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.Chapter;
import org.springframework.http.ResponseEntity;

public interface ChapterService {

    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long chapterId);

    ResponseEntity<Object> save(Chapter chapter);

    ResponseEntity<Object> update(Chapter chapter);

    ResponseEntity<Object> delete(Long chapterId);
}
