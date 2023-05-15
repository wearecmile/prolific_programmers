package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.Role;
import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.entity.UserFcmToken;
import com.cmile.meetmate.enums.Permission;
import com.cmile.meetmate.models.request.AuthenticationRequest;
import com.cmile.meetmate.models.response.AuthResponse;
import com.cmile.meetmate.repository.UserRepository;
import com.cmile.meetmate.service.AuthService;
import com.cmile.meetmate.service.UserFcmTokenService;
import com.cmile.meetmate.utils.constant.StringConstants;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private FirebaseAuth firebaseAuth;
    @Autowired
    private UserFcmTokenService userFcmTokenService;

    @Override
    public AuthResponse setClaims(AuthenticationRequest request) throws FirebaseAuthException {
        List<Permission> permissionArrayList = new ArrayList<>();
        String userPhoneNumber = firebaseAuth.getUser(request.getUid()).getPhoneNumber();
        Optional<User> user = userRepository.findByUserContact(userPhoneNumber);
        if (user.isPresent()) {
            Role userRole = user.get().getRole();
            permissionArrayList.add(Permission.valueOf(userRole.getRoleName().toString()));
            List<String> permissions = permissionArrayList
                    .stream()
                    .map(Enum::toString)
                    .collect(Collectors.toList());
            Map<String, Object> claims = Map.of(StringConstants.CUSTOM_ROLE_STRING_CONSTANT, permissions);
            Optional<UserFcmToken> userFcmTokenOptional = userFcmTokenService.findByUserId(user.get().getUserId());
            if (userFcmTokenOptional.isPresent()) {
                UserFcmToken userFcmToken = userFcmTokenOptional.get();
                userFcmToken.setUftUid(request.getUid());
                userFcmToken.setUftFcmToken(request.getFcmDeviceToken());
                userFcmToken.setUftDeviceType(request.getDeviceOS());
                userFcmToken.setUftIsActive(Boolean.TRUE);
                firebaseAuth.setCustomUserClaims(request.getUid(), claims);
                return authResponseGenerator(userFcmTokenService.update(userFcmToken), userRole, user.get());

            }
            UserFcmToken userFcmToken = new UserFcmToken();
            userFcmToken.setUftUserId(user.get().getUserId());
            userFcmToken.setUftUid(request.getUid());
            userFcmToken.setUftFcmToken(request.getFcmDeviceToken());
            userFcmToken.setUftDeviceType(request.getDeviceOS());
            userFcmToken.setUftIsActive(Boolean.TRUE);
            firebaseAuth.setCustomUserClaims(request.getUid(), claims);
            return authResponseGenerator(userFcmTokenService.save(userFcmToken), userRole, user.get());
        }
        return null;

    }

    @Override
    public AuthResponse authResponseGenerator(UserFcmToken userFcmToken, Role role, User user) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUser(user);
        authResponse.setUid(userFcmToken.getUftUid());
        authResponse.setActive(userFcmToken.getUftIsActive());
        authResponse.setDeviceType(userFcmToken.getUftDeviceType());
        authResponse.setFcmToken(userFcmToken.getUftFcmToken());
        authResponse.setUserRole(role);
        return authResponse;
    }
}
