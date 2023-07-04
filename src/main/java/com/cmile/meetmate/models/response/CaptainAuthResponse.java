package com.cmile.meetmate.models.response;

import com.cmile.meetmate.entity.Group;
import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.enums.RoleEnum;
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
@JsonInclude(JsonInclude.Include.ALWAYS)
public class CaptainAuthResponse {
    private String deviceType;
    private String fcmToken;
    private String uid;
    private boolean isActive;
    private User user;
    private List<Group> group;
    private RoleEnum userRole;
}
