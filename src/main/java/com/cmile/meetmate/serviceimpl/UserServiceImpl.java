package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.model.JsonResponse;
import com.cmile.meetmate.repository.UserRepository;
import com.cmile.meetmate.service.UserService;
import com.cmile.meetmate.utils.constant.StringConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<User> userList=userRepository.findAll();
        if (!userList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_USER_FETCHED)
                            .status(HttpStatus.OK)
                            .data(userList)
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_SELECTED_USER_FETCHED +userId)
                            .status(HttpStatus.OK)
                            .data(userOptional.get())
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> save(User user) {
        User savedUser = userRepository.save(user);
        if (savedUser != null)
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_USER_CREATED)
                            .status(HttpStatus.OK)
                            .data(savedUser)
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(User user) {
        Optional<User> optionalUser=userRepository.findById(user.getUserId());
        if (optionalUser.isPresent()) {
            User updateUser=optionalUser.get();
            updateUser.setUserName(user.getUserName());
            updateUser.setUserContact(user.getUserName());
            updateUser.setUserOpeningBalance(user.getUserOpeningBalance());
            updateUser.setUserClosingBalance(user.getUserClosingBalance());
            updateUser.setUserUpdatedDateTime(user.getUserUpdatedDateTime());
            updateUser=userRepository.save(updateUser);
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_USER_UPDATED)
                            .status(HttpStatus.OK)
                            .data(optionalUser)
                            .build());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> delete(Long userId) {
            if (userRepository.findById(userId).isPresent()) {
                userRepository.deleteById(userId);
                return ResponseEntity.status(HttpStatus.OK).body(
                        JsonResponse.builder()
                                .statusCode(HttpStatus.OK.value())
                                .message(StringConstant.REQUEST_SUCCESS_MESSAGE_USER_DELETED)
                                .status(HttpStatus.OK)
                                .build());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                            .status(HttpStatus.BAD_REQUEST)
                            .build());
    }
}
