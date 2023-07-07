package com.cmile.meetmate.factorymethod;

import com.cmile.meetmate.models.firebase.FirebaseNotification;

import java.util.List;

public interface Notifications {

    void sendNotificationToFcmToken(FirebaseNotification userNotification);

    void sendNotificationToAllFcmToken(List<FirebaseNotification> userNotification);
}
