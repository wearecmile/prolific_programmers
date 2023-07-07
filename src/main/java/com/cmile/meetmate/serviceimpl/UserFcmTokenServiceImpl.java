package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.UserFcmToken;
import com.cmile.meetmate.repository.UserFcmTokenRepository;
import com.cmile.meetmate.service.UserFcmTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserFcmTokenServiceImpl implements UserFcmTokenService {

    @Autowired
    UserFcmTokenRepository userFcmTokenRepository;

    @Override
    public UserFcmToken save(UserFcmToken userFcmToken) {
        return userFcmTokenRepository.save(userFcmToken);
    }

    @Override
    public UserFcmToken update(UserFcmToken userFcmToken) {
        return userFcmTokenRepository.save(userFcmToken);
    }

    @Override
    public Optional<UserFcmToken> findByUserId(Long userId) {
        return userFcmTokenRepository.findById(userId);
    }

    @Override
    public List<UserFcmToken> findByUserIdAndUftDeviceType(Long userId, String uftDeviceType) {
        return userFcmTokenRepository.findByUserIdAndUftDeviceType(userId, uftDeviceType);
    }
}
