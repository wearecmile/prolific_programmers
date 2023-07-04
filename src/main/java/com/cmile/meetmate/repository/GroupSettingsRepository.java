package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.GroupSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupSettingsRepository extends JpaRepository<GroupSettings, Long> {
}
