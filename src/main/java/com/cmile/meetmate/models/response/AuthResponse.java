package com.cmile.meetmate.models.response;

import com.cmile.meetmate.entity.Group;
import com.cmile.meetmate.entity.Role;
import com.cmile.meetmate.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthResponse {
    private String deviceType;
    private String fcmToken;
    private String uid;
    private boolean isActive;
    private User user;
    private Role userRole;
    private List<Group> group;
}
