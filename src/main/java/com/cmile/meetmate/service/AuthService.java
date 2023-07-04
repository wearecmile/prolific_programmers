package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.Group;
import com.cmile.meetmate.entity.Role;
import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.entity.UserFcmToken;
import com.cmile.meetmate.enums.RoleEnum;
import com.cmile.meetmate.models.request.AuthenticationRequest;
import com.cmile.meetmate.models.response.AuthResponse;
import com.cmile.meetmate.models.response.CaptainAuthResponse;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public interface AuthService {

    AuthResponse setClaims(AuthenticationRequest request) throws FirebaseAuthException;

    AuthResponse authResponseGenerator(UserFcmToken userFcmToken, Role role, User user);

    CaptainAuthResponse authCaptainResponseGenerator(UserFcmToken userFcmToken, List<Group> groupList, RoleEnum roleEnum);
}
