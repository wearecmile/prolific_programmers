package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.UserChapter;
import org.springframework.http.ResponseEntity;

public interface UserChapterService {
    ResponseEntity<Object> findAll();

    ResponseEntity<Object> findById(Long ucId);

    ResponseEntity<Object> save(UserChapter userChapter);

    ResponseEntity<Object> update(UserChapter userChapter);

    ResponseEntity<Object> delete(Long ucId);

    ResponseEntity<Object> findAllUserId(Long ucUserId);

    ResponseEntity<Object> findAllChapterId(Long ucChapterId);
}
