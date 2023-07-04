package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.GroupSettings;
import com.cmile.meetmate.models.JsonResponse;
import com.cmile.meetmate.repository.GroupSettingsRepository;
import com.cmile.meetmate.service.GroupSettingService;
import com.cmile.meetmate.utils.constant.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupSettingsServiceImpl implements GroupSettingService {
    @Autowired
    GroupSettingsRepository groupSettingsRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<GroupSettings> groupSettingsList = groupSettingsRepository.findAll();
        if (groupSettingsList.isEmpty()) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_GROUP_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(groupSettingsList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_GROUP_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long groupSettingsId) {
        Optional<GroupSettings> optionalGroupSettings = groupSettingsRepository.findById(groupSettingsId);
        if (optionalGroupSettings.isPresent()) {
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalGroupSettings)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_SELECTED_GROUP_FETCHED + groupSettingsId)
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
    public ResponseEntity<Object> save(GroupSettings groupSettings) {
        groupSettings = groupSettingsRepository.save(groupSettings);
        if (groupSettings == null) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_GROUP_NOT_CREATED)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(groupSettings)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_GROUP_CREATED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(GroupSettings groupSettings) {
        Optional<GroupSettings> optionalGroupSettings = groupSettingsRepository.findById(groupSettings.getGsId());
        if (optionalGroupSettings.isPresent()) {
            GroupSettings updateGroupSettings = optionalGroupSettings.get();
            groupSettingsRepository.save(updateGroupSettings);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalGroupSettings)
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
    public ResponseEntity<Object> delete(Long groupSettingsId) {
        if (groupSettingsRepository.findById(groupSettingsId).isPresent()) {
            groupSettingsRepository.deleteById(groupSettingsId);
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
