package com.cmile.meetmate.utils.constant;

public class StringConstants {
    // Text Constants
    public static final String TEXT_EMPTY = "";
    public static final String TEXT_SPACE = " ";
    public static final String TEXT_FOR = "for ";
    public static final String TEXT_TO = " to ";
    public static final String TEXT_SLASH = "/";
    public static final String TEXT_COLON = ":";
    public static final String TEXT_TYPE_TEXT_HTML = "text/html";
    public static final String TEXT_DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String TEXT_TIME_FORMAT_HH_MM = "HH:mm";
    public static final String TEXT_TIME_ZONE = "UTC";
    public static final String DEFAULT_IS_ACTIVE = "true";
    public static final String TEXT_TOPIC_PUBLISHING_KEY = "/p";
    public static final String TEXT_STATIC_COUNTRY_CODE = "+91";
    public static final String TEXT_MQTT_RESPONSE_OK = "OK";
    public static final String TEXT_DECIMAL_FORMAT_PATTERN = "#.##";

    //User Controller
    public static final String REQUEST_SUCCESS_MESSAGE_USER_CREATED = "User Created Successfully!!";
    public static final String REQUEST_FAILURE_MESSAGE_USER_NOT_CREATED = "Failed to Create User";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_UPDATED = "User Updated Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_DELETED = "User Deleted Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_FETCHED = "User Fetched Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_SELECTED_USER_FETCHED = "Fetched User by id: ";
    public static final String REQUEST_FAILURE_MESSAGE_NO_USER_FOUND = "No User Found";

    //Group Controller
    public static final String REQUEST_SUCCESS_MESSAGE_GROUP_CREATED = "Group Created Successfully!!";
    public static final String REQUEST_FAILURE_MESSAGE_GROUP_NOT_CREATED = "Failed to Create Group";
    public static final String REQUEST_SUCCESS_MESSAGE_GROUP_UPDATED = "Group Updated Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_GROUP_DELETED = "Group Deleted Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_GROUP_FETCHED = "Group Fetched Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_SELECTED_GROUP_FETCHED = "Fetched Group by id: ";
    public static final String REQUEST_FAILURE_MESSAGE_NO_GROUP_FOUND = "No Group Found";


    //User Group Controller
    public static final String REQUEST_SUCCESS_MESSAGE_USER_GROUP_CREATED = "User Group Created Successfully!!";
    public static final String REQUEST_FAILURE_MESSAGE_USER_GROUP_NOT_CREATED = "Failed to Create User Group";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_GROUP_UPDATED = "User Group Updated Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_GROUP_DELETED = "User Group Deleted Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_GROUP_FETCHED = "User Group Fetched Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_SELECTED_USER_GROUP_FETCHED = "Fetched User Group by id: ";
    public static final String REQUEST_FAILURE_MESSAGE_NO_USER_GROUP_FOUND = "No User Group Found";
    public static final String REQUEST_FAILURE_MESSAGE_NO_GROUP_MEMBERS_FOUND = "No members found for group id: ";
    public static final String REQUEST_FAILURE_MESSAGE_NO_MEMBER_GROUP_FOUND = "No group found for user id: ";
    public static final String REQUEST_SUCCESS_MESSAGE_GROUP_MEMBERS_FETCHED = "Group members fetched successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_MEMBER_GROUPS_FETCHED = "Groups fetched successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_GROUP_FETCHED_BY_USER = "User Group Fetched By User Successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_GROUP_FETCHED_BY_GROUP = "User Fetched By User Group Successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_GROUP_FETCHED_BY_GROUP_AND_ROLE = "User Group Fetched By Group And Role Successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_GROUP_CAPTAIN_UPDATED = "User Group Captain Updated";

    //Role Controller
    public static final String REQUEST_SUCCESS_MESSAGE_ROLE_CREATED = "Role Created Successfully!!";
    public static final String REQUEST_FAILURE_MESSAGE_ROLE_NOT_CREATED = "Failed to Create Role";
    public static final String REQUEST_SUCCESS_MESSAGE_ROLE_UPDATED = "Role Updated Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_ROLE_DELETED = "Role Deleted Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_ROLE_FETCHED = "Role Fetched Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_SELECTED_ROLE_FETCHED = "Fetched Role by id: ";
    public static final String REQUEST_FAILURE_MESSAGE_NO_ROLE_FOUND = "No Role Found";

    //Group Settings Controller
    public static final String REQUEST_SUCCESS_MESSAGE_GROUP_SETTINGS_CREATED = "Group Settings Created Successfully!!";
    public static final String REQUEST_FAILURE_MESSAGE_GROUP_SETTINGS_NOT_CREATED = "Failed to Create Group Settings";
    public static final String REQUEST_SUCCESS_MESSAGE_GROUP_SETTINGS_UPDATED = "Group Settings Updated Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_GROUP_SETTINGS_DELETED = "Group Settings Deleted Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_GROUP_SETTINGS_FETCHED = "Group Settings Fetched Successfully!!";
    public static final String REQUEST_SUCCESS_MESSAGE_SELECTED_GROUP_SETTINGS_FETCHED = "Fetched Group Settings by id: ";
    public static final String REQUEST_FAILURE_MESSAGE_NO_GROUP_SETTINGS_FOUND = "No Group Settings Found";
    public static final String REQUEST_FAILURE_MESSAGE_SETTING_ALREADY_PRESENT = "Group settings already exists for group id: ";

    //Swagger Constant
    public static final String TEXT_SWAGGER_TITLE = "All meet mate APIs";
    public static final String TEXT_SWAGGER_DESC = "REST APIs reference for developers";
    public static final String TEXT_SWAGGER_CONTACT_EMAIL = "cmile@gmail.com";
    public static final String TEXT_SWAGGER_LICENCE = "http://licence-url.com";
    public static final String TEXT_APP_NAME = "meet mate";
    public static final String TEXT_SWAGGER_API_VERSION = "1.0";
    public static final String TEXT_SWAGGER_REGEX_PATH = "/*.*";

    //Attendance Controller
    public static final String REQUEST_SUCCESS_MESSAGE_ATTENDANCE_CREATED = "Attendance created successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_MULTIPLE_ATTENDANCE_CREATED = "Multiple Attendance created successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_ATTENDANCE_FETCHED = "Attendance fetched successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_ATTENDANCE_DELETED = "Attendance deleted successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_ATTENDANCE_UPDATED = "Attendance updated successfully";
    public static final String REQUEST_FAILURE_MESSAGE_ATTENDANCE_NOT_CREATED = "Failed to create Attendance";
    public static final String REQUEST_FAILURE_MESSAGE_NO_ATTENDANCE_FOUND = "No Attendance found";

    //Meeting Controller
    public static final String REQUEST_SUCCESS_MESSAGE_MEETING_CREATED = "Meeting created successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_MEETING_FETCHED = "Meeting fetched successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_MEETING_DELETED = "Meeting deleted successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_MEETING_UPDATED = "Meeting updated successfully";
    public static final String REQUEST_FAILURE_MESSAGE_MEETING_NOT_CREATED = "Failed to create Meeting";
    public static final String REQUEST_FAILURE_MESSAGE_NO_MEETING_FOUND = "No Meeting found";

    //Payment History Controller
    public static final String REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_CREATED = "Payment History created successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_FETCHED = "Payment History fetched successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_DELETED = "Payment History deleted successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_PAYMENT_HISTORY_UPDATED = "Payment History updated successfully";
    public static final String REQUEST_FAILURE_MESSAGE_PAYMENT_HISTORY_NOT_CREATED = "Failed to create Payment History";
    public static final String REQUEST_FAILURE_MESSAGE_NO_PAYMENT_HISTORY_FOUND = "No Payment History found";

    //User Chapter Controller
    public static final String REQUEST_SUCCESS_MESSAGE_USER_CHAPTER_CREATED = "User Chapter created successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_CHAPTER_FETCHED = "User Chapter fetched successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_CHAPTER_DELETED = "User Chapter deleted successfully";
    public static final String REQUEST_SUCCESS_MESSAGE_USER_CHAPTER_UPDATED = "User Chapter updated successfully";
    public static final String REQUEST_FAILURE_MESSAGE_USER_CHAPTER_NOT_CREATED = "Failed to create User Chapter";
    public static final String REQUEST_FAILURE_MESSAGE_NO_USER_CHAPTER_FOUND = "No User Chapter found";

    //Auth
    public static final String CUSTOM_ROLE_STRING_CONSTANT = "custom_claims";
    public static final String CAPTAIN_ROLE_STRING_CONSTANT = "captain_claims";
    public static final String REQUEST_FAILURE_MESSAGE_UNAUTHORIZED_TOKEN = "Unauthorized token found";
    public static final String REQUEST_FAILURE_MESSAGE_AUTHENTICATION_FAILED = "Entered User doesn't have required permission.Please contact Admin!";
    public static final String REQUEST_SUCCESS_MESSAGE_AUTH_SUCCESS = "Auth successful!!";

}
