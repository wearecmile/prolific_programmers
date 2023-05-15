package com.cmile.meetmate.config;

import com.cmile.meetmate.models.JsonResponse;
import com.cmile.meetmate.utils.constant.StringConstants;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FirebaseAuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.getWriter().print(new Gson().toJson(JsonResponse.builder()
                .message(StringConstants.REQUEST_FAILURE_MESSAGE_UNAUTHORIZED_TOKEN)
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .status(HttpStatus.UNAUTHORIZED)
                .build()));
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
