package com.cmile.meetmate.models.firebase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FirebaseNotification {
    private String title;
    private String content;
    private String deviceType;
    private Map<String, String> data;
    private String fcmToken;
}
