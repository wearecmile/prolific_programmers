package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.UserFcmToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFcmTokenRepository extends JpaRepository<UserFcmToken, Long> {
    List<UserFcmToken> findByUserIdAndUftDeviceType(Long userId, String uftDeviceType);
}
