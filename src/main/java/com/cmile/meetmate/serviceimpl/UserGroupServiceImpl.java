package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.Group;
import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.entity.UserGroup;
import com.cmile.meetmate.enums.RoleEnum;
import com.cmile.meetmate.models.JsonResponse;
import com.cmile.meetmate.repository.UserGroupRepository;
import com.cmile.meetmate.service.UserGroupService;
import com.cmile.meetmate.utils.constant.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    UserGroupRepository userGroupRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<UserGroup> userGroupList = userGroupRepository.findAll();
        if (userGroupList.isEmpty()) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_GROUP_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(userGroupList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_GROUP_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long ugId) {
        Optional<UserGroup> optionalUserGroup = userGroupRepository.findById(ugId);
        if (optionalUserGroup.isPresent()) {
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalUserGroup)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_SELECTED_USER_GROUP_FETCHED + ugId)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_GROUP_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> save(UserGroup userGroup) {
        UserGroup userGroupExists = userGroupRepository.findByUgUserIdAndUgGroupId(userGroup.getUgUserId(), userGroup.getUgGroupId());
        if(userGroupExists!=null)
            userGroup.setUgId(userGroupExists.getUgId());
        userGroup = userGroupRepository.save(userGroup);
        if (userGroup == null) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_USER_GROUP_NOT_CREATED)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(userGroup)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_GROUP_CREATED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(UserGroup userGroup) {
        Optional<UserGroup> optionalUserGroup = userGroupRepository.findById(userGroup.getUgId());
        if (optionalUserGroup.isPresent()) {
            UserGroup updateUserGroup = userGroupRepository.save(userGroup);
            userGroupRepository.save(updateUserGroup);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(updateUserGroup)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_GROUP_UPDATED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_GROUP_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> delete(Long ugId) {
        if (userGroupRepository.findById(ugId).isPresent()) {
            userGroupRepository.deleteById(ugId);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_GROUP_DELETED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_GROUP_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findGroupsByUserId(Long userId) {
        List<Group> groupList = userGroupRepository.findByUserId(userId);
        if (groupList.isEmpty()) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_MEMBER_GROUP_FOUND + userId)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(groupList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_MEMBER_GROUPS_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findGroupMembers(Long groupId) {
        List<User> users = userGroupRepository.findByGroupId(groupId);
        if (users.isEmpty()) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_GROUP_MEMBERS_FOUND + groupId)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(users)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_GROUP_MEMBERS_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

//    @Override
//    public ResponseEntity<Object> findAllByUser(Long userId) {
//        List<UserGroup> userGroupList = userGroupRepository.findAllByUgUserId(userId);
//        if (userGroupList.isEmpty())
//            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
//                    .body(JsonResponse.builder()
//                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_GROUP_FOUND)
//                            .status(HttpStatus.BAD_REQUEST)
//                            .statusCode(HttpStatus.BAD_REQUEST.value())
//                            .build());
//
//        return ResponseEntity.status((HttpStatus.OK))
//                .body(JsonResponse.builder()
//                        .data(userGroupList)
//                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_GROUP_FETCHED_BY_USER)
//                        .status(HttpStatus.OK)
//                        .statusCode(HttpStatus.OK.value())
//                        .build());
//    }

//    @Override
//    public ResponseEntity<Object> findAllByGroup(Long groupId) {
//        List<UserGroup> userGroupList = userGroupRepository.findAllByUgGroupId(groupId);
//        if (userGroupList.isEmpty())
//            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
//                    .body(JsonResponse.builder()
//                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_GROUP_FOUND)
//                            .status(HttpStatus.BAD_REQUEST)
//                            .statusCode(HttpStatus.BAD_REQUEST.value())
//                            .build());
//
//        return ResponseEntity.status((HttpStatus.OK))
//                .body(JsonResponse.builder()
//                        .data(userGroupList)
//                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_GROUP_FETCHED_BY_GROUP)
//                        .status(HttpStatus.OK)
//                        .statusCode(HttpStatus.OK.value())
//                        .build());
//    }

    @Override
    public ResponseEntity<Object> findByGroupAndRole(Long groupId, RoleEnum roleName) {
        List<UserGroup> userGroupList = userGroupRepository.findAllByUgGroupIdAndUgRoleName(groupId, roleName);
        if (userGroupList.isEmpty())
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_GROUP_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(userGroupList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_GROUP_FETCHED_BY_GROUP_AND_ROLE)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> makeCaptain(Long userGroupId) {
        Optional<UserGroup> optionalUserGroup = userGroupRepository.findById(userGroupId);
        if (optionalUserGroup.isPresent()) {
            UserGroup updateUserGroup = optionalUserGroup.get();
            updateUserGroup.setUgRoleName(RoleEnum.CAPTAIN);
            userGroupRepository.save(updateUserGroup);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalUserGroup)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_GROUP_CAPTAIN_UPDATED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_GROUP_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }
}
