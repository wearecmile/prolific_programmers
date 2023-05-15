package com.cmile.meetmate.service;

import com.cmile.meetmate.entity.Role;
import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.entity.UserFcmToken;
import com.cmile.meetmate.models.request.AuthenticationRequest;
import com.cmile.meetmate.models.response.AuthResponse;
import com.google.firebase.auth.FirebaseAuthException;

public interface AuthService {

    AuthResponse setClaims(AuthenticationRequest request) throws FirebaseAuthException;

    AuthResponse authResponseGenerator(UserFcmToken userFcmToken, Role role, User user);
}
