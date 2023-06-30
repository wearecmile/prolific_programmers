package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.Group;
import com.cmile.meetmate.models.JsonResponse;
import com.cmile.meetmate.repository.GroupRepository;
import com.cmile.meetmate.service.GroupService;
import com.cmile.meetmate.utils.constant.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<Group> groupList = groupRepository.findAll();
        if (groupList.isEmpty()) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_GROUP_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(groupList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_GROUP_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long groupId) {
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        if (optionalGroup.isPresent()) {
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalGroup)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_SELECTED_GROUP_FETCHED + groupId)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_GROUP_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> save(Group group) {
        group = groupRepository.save(group);
        if (group == null) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_GROUP_NOT_CREATED)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(group)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_GROUP_CREATED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(Group group) {
        Optional<Group> optionalGroup = groupRepository.findById(group.getGroupId());
        if (optionalGroup.isPresent()) {
            Group updateGroup = optionalGroup.get();
            updateGroup.setGroupName(group.getGroupName());
            updateGroup.setGroupDescription(group.getGroupDescription());
            updateGroup.setGroupUpdatedDateTime(group.getGroupUpdatedDateTime());
            groupRepository.save(updateGroup);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalGroup)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_GROUP_UPDATED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_GROUP_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> delete(Long groupId) {
        if (groupRepository.findById(groupId).isPresent()) {
            groupRepository.deleteById(groupId);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_GROUP_DELETED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_GROUP_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }
}
