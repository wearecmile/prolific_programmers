package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.UserChapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserChapterRepository extends JpaRepository<UserChapter, Long> {

    List<UserChapter> findAllUcChapterIdByUcUserId(Long ucChapterId);

    List<UserChapter> findAllUcUserIdByUcChapterId(Long ucUserId);

}
