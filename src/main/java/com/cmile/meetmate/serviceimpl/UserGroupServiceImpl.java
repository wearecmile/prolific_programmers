package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.UserGroup;
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
            UserGroup updateUserGroup = optionalUserGroup.get();
            updateUserGroup.setUgGroupId(userGroup.getUgGroupId());
            updateUserGroup.setUgUserId(userGroup.getUgUserId());
            updateUserGroup.setUgRoleName(userGroup.getUgRoleName());
            updateUserGroup.setUgUpdatedDateTime(userGroup.getUgUpdatedDateTime());
            userGroupRepository.save(updateUserGroup);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalUserGroup)
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
}
