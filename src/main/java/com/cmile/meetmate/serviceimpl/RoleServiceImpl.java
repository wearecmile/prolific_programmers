package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.Role;
import com.cmile.meetmate.model.JsonResponse;
import com.cmile.meetmate.repository.RoleRepository;
import com.cmile.meetmate.service.RoleService;
import com.cmile.meetmate.utils.constant.StringConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<Role> roleList = roleRepository.findAll();
        if (!roleList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_ROLE_FETCHED)
                            .status(HttpStatus.OK)
                            .data(roleList)
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_SELECTED_ROLE_FETCHED +roleId)
                            .status(HttpStatus.OK)
                            .data(roleOptional.get())
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> save(Role role) {
        Role savedRole = roleRepository.save(role);
        if (savedRole != null)
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_ROLE_CREATED)
                            .status(HttpStatus.OK)
                            .data(savedRole)
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(Role role) {
        Optional<Role> optionalRole = roleRepository.findById(role.getRoleId());
        if (optionalRole.isPresent()) {
            Role updateRole=optionalRole.get();
            updateRole.setRoleName(role.getRoleName());
            updateRole.setRoleUpdatedDateTime(role.getRoleUpdatedDateTime());
            roleRepository.save(updateRole);
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_ROLE_UPDATED)
                            .status(HttpStatus.OK)
                            .data(optionalRole)
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
    public ResponseEntity<Object> delete(Long roleId) {
        if (roleRepository.findById(roleId).isPresent()) {
            roleRepository.deleteById(roleId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_ROLE_DELETED)
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
