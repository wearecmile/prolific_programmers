package com.cmile.meetmate.controller;

import com.cmile.meetmate.models.JsonResponse;
import com.cmile.meetmate.models.request.AuthenticationRequest;
import com.cmile.meetmate.models.response.AuthResponse;
import com.cmile.meetmate.service.AuthService;
import com.cmile.meetmate.utils.constant.ApiConstants;
import com.cmile.meetmate.utils.constant.StringConstants;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.REQUEST_MAPPING_KEY_AUTH)
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping
    public ResponseEntity<JsonResponse> setClaims(@RequestBody AuthenticationRequest request) throws FirebaseAuthException {
        AuthResponse authResponse = authService.setClaims(request);
        if (authResponse == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_AUTHENTICATION_FAILED)
                            .status(HttpStatus.NOT_FOUND)
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build());

        return ResponseEntity.status(HttpStatus.OK)
                .body(JsonResponse.builder()
                        .data(authResponse)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_AUTH_SUCCESS)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
}
