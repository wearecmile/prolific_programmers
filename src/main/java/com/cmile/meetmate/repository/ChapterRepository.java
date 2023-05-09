package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter,Long> {
}
