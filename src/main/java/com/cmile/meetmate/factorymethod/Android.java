package com.cmile.meetmate.factorymethod;

import com.cmile.meetmate.models.firebase.FirebaseNotification;
import com.google.firebase.messaging.*;

import java.util.ArrayList;
import java.util.List;

public class Android implements Notifications {
    @Override
    public void sendNotificationToFcmToken(FirebaseNotification userNotification) {
        Notification notification = Notification
                .builder()
                .setTitle(userNotification.getTitle())
                .setBody(userNotification.getContent())
                .build();
        Message message = Message
                .builder()
                .setToken(userNotification.getFcmToken())
                .build();
        FirebaseMessaging.getInstance().sendAsync(message);
    }

    @Override
    public void sendNotificationToAllFcmToken(List<FirebaseNotification> userNotification) {
        List<Message> messages = new ArrayList<>();
        for (FirebaseNotification memberNotification : userNotification) {
            Notification notification = Notification
                    .builder()
                    .setTitle(memberNotification.getTitle())
                    .setBody(memberNotification.getContent())
                    .build();
            Message message = Message
                    .builder()
                    .setAndroidConfig(AndroidConfig
                            .builder()
                            .setNotification(AndroidNotification
                                    .builder()
                                    .setTitle(memberNotification.getTitle())
                                    .setBody(memberNotification.getContent())
                                    .build())
                            .build())
                    .setToken(memberNotification.getFcmToken())
                    .build();
            messages.add(message);
        }
        if (!messages.isEmpty())
            FirebaseMessaging.getInstance().sendAllAsync(messages);
    }
}
