package com.cmile.meetmate.factorymethod;

public class NotificationFactory {
    public Notifications getNotification(String notificationType) {
        if (notificationType == null) {
            return null;
        }
        if (notificationType.equalsIgnoreCase("android")) {
            return new Android();

        } else if (notificationType.equalsIgnoreCase("ios")) {
            return new Ios();

        } else if (notificationType.equalsIgnoreCase("web")) {
            return new Web();
        }
        return null;
    }
}
