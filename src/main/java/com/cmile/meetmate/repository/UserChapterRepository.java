package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.UserChapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChapterRepository extends JpaRepository<UserChapter, Long> {
}
