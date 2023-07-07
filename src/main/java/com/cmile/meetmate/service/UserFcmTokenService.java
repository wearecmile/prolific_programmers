package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.UserFcmToken;

import java.util.List;
import java.util.Optional;

public interface UserFcmTokenService {

    UserFcmToken save(UserFcmToken userFcmToken);

    UserFcmToken update(UserFcmToken userFcmToken);

    Optional<UserFcmToken> findByUserId(Long userId);

    List<UserFcmToken> findByUserIdAndUftDeviceType(Long userId, String android);
}
