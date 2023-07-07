package com.cmile.meetmate.utils;

import com.cmile.meetmate.entity.Meeting;
import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.entity.UserFcmToken;
import com.cmile.meetmate.factorymethod.NotificationFactory;
import com.cmile.meetmate.factorymethod.Notifications;
import com.cmile.meetmate.models.firebase.FirebaseNotification;
import com.cmile.meetmate.repository.MeetingRepository;
import com.cmile.meetmate.repository.UserGroupRepository;
import com.cmile.meetmate.service.UserFcmTokenService;
import com.cmile.meetmate.utils.constant.IntegerConstants;
import com.cmile.meetmate.utils.constant.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Scheduler {
    @Autowired
    MeetingRepository meetingRepository;

    @Autowired
    UserFcmTokenService userFcmTokenService;

    @Autowired
    UserGroupRepository userGroupRepository;

    @Scheduled(cron = "0 0 8 * * *")
    public void dailyMeeting() {

    }

    @Scheduled(cron = "${cron.meetingExpression}")
    public void meetingNotification() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, IntegerConstants.INT_MINUS_ONE);
        List<Meeting> meetingList = meetingRepository.findAllByMeetingCreatedDate(calendar.getTime());
        List<FirebaseNotification> firebaseNotificationsAndroid = new ArrayList<>();
        List<FirebaseNotification> firebaseNotificationsWeb = new ArrayList<>();
        List<FirebaseNotification> firebaseNotificationsIos = new ArrayList<>();
        for (Meeting meeting : meetingList) {
            Date date = meeting.getMeetingDate();
            List<User> userGroupList = userGroupRepository.findByGroupId(meeting.getMeetingGroupId());
            for (User user : userGroupList) {
                String name = user.getUserName();
                String role = user.getRole().getRoleName().toString();
                List<UserFcmToken> userFcmTokenListAndroid = userFcmTokenService.findByUserIdAndUftDeviceType(user.getUserId(), "android");
                List<UserFcmToken> userFcmTokenListIos = userFcmTokenService.findByUserIdAndUftDeviceType(user.getUserId(), "ios");
                List<UserFcmToken> userFcmTokenListWeb = userFcmTokenService.findByUserIdAndUftDeviceType(user.getUserId(), "web");
                for (UserFcmToken userFcmTokenAndroid : userFcmTokenListAndroid) {
                    FirebaseNotification firebaseNotification = FirebaseNotification
                            .builder()
                            .fcmToken(userFcmTokenAndroid.getUftFcmToken())
                            .title("Meeting Scheduled")
                            .content(role + StringConstants.TEXT_SPACE + name + "Scheduled On" + date)
                            .build();
                    firebaseNotificationsAndroid.add(firebaseNotification);
                }
                for (UserFcmToken userFcmTokenIos : userFcmTokenListIos) {
                    FirebaseNotification firebaseNotification = FirebaseNotification
                            .builder()
                            .fcmToken(userFcmTokenIos.getUftFcmToken())
                            .title("Meeting Scheduled")
                            .content(role + StringConstants.TEXT_SPACE + name + "Scheduled On" + date)
                            .build();
                    firebaseNotificationsIos.add(firebaseNotification);
                }
                for (UserFcmToken userFcmTokenWeb : userFcmTokenListWeb) {
                    FirebaseNotification firebaseNotification = FirebaseNotification
                            .builder()
                            .fcmToken(userFcmTokenWeb.getUftFcmToken())
                            .title("Meeting Scheduled")
                            .content(role + StringConstants.TEXT_SPACE + name + "Scheduled On" + date)
                            .build();
                    firebaseNotificationsWeb.add(firebaseNotification);
                }
            }
        }
        NotificationFactory notificationFactory = new NotificationFactory();
        Notifications notificationsAndroid = notificationFactory.getNotification("android");
        notificationsAndroid.sendNotificationToAllFcmToken(firebaseNotificationsAndroid);
        Notifications notificationsIos = notificationFactory.getNotification("ios");
        notificationsIos.sendNotificationToAllFcmToken(firebaseNotificationsIos);
        Notifications notificationsWeb = notificationFactory.getNotification("web");
        notificationsWeb.sendNotificationToAllFcmToken(firebaseNotificationsWeb);
    }
}
