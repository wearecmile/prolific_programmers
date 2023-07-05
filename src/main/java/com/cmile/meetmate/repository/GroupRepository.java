package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAllByGroupCreatedBy(Long groupCreatedBy);
}
