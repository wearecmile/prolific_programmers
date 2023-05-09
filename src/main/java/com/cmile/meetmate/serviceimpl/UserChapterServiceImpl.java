package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.UserChapter;
import com.cmile.meetmate.models.JsonResponse;
import com.cmile.meetmate.repository.UserChapterRepository;
import com.cmile.meetmate.service.UserChapterService;
import com.cmile.meetmate.utils.constant.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserChapterServiceImpl implements UserChapterService {
    @Autowired
    UserChapterRepository userChapterRepository;
    @Override
    public ResponseEntity<Object> findAll() {
        List<UserChapter> userChapterList = userChapterRepository.findAll();
        if(userChapterList.isEmpty()){
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_CHAPTER_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(userChapterList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_CHAPTER_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long ucId) {
        Optional<UserChapter> optionalUserChapter = userChapterRepository.findById(ucId);
        if(optionalUserChapter.isPresent()){
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalUserChapter)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_CHAPTER_FETCHED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_CHAPTER_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> save(UserChapter userChapter) {
            userChapter = userChapterRepository.save(userChapter);
            if(userChapter == null){
                return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                        .body(JsonResponse.builder()
                                .message(StringConstants.REQUEST_FAILURE_MESSAGE_USER_CHAPTER_NOT_CREATED)
                                .status(HttpStatus.BAD_REQUEST)
                                .statusCode(HttpStatus.BAD_REQUEST.value())
                                .build());
            }
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(userChapter)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_CHAPTER_CREATED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
    }

    @Override
    public ResponseEntity<Object> update(UserChapter userChapter) {
            Optional<UserChapter> optionalUserChapter = userChapterRepository.findById(userChapter.getUcId());
            if(optionalUserChapter.isPresent()){
                UserChapter updateUserChapter = optionalUserChapter.get();
                updateUserChapter.setUcUpdatedDateTime(userChapter.getUcUpdatedDateTime());
                updateUserChapter = userChapterRepository.save(updateUserChapter);
                return ResponseEntity.status((HttpStatus.OK))
                        .body(JsonResponse.builder()
                                .data(optionalUserChapter)
                                .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_CHAPTER_UPDATED)
                                .status(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .build());
            }
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_CHAPTER_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
    }

    @Override
    public ResponseEntity<Object> delete(Long ucId) {
            if(userChapterRepository.findById(ucId).isPresent()){
                userChapterRepository.deleteById(ucId);
                return ResponseEntity.status((HttpStatus.OK))
                        .body(JsonResponse.builder()
                                .message(StringConstants.REQUEST_SUCCESS_MESSAGE_USER_CHAPTER_DELETED)
                                .status(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .build());
            }
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_USER_CHAPTER_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
    }
}
