package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.Attendance;
import com.cmile.meetmate.entity.Role;
import com.cmile.meetmate.enums.RoleEnum;
import com.cmile.meetmate.models.JsonResponse;
import com.cmile.meetmate.repository.AttendanceRepository;
import com.cmile.meetmate.repository.RoleRepository;
import com.cmile.meetmate.service.AttendanceService;
import com.cmile.meetmate.utils.constant.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<Attendance> attendanceList = attendanceRepository.findAll();
        if (attendanceList.isEmpty()) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_ATTENDANCE_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }

        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(attendanceList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_ATTENDANCE_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long attendanceId) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendanceId);
        if (optionalAttendance.isPresent()) {
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalAttendance)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_ATTENDANCE_FETCHED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_ATTENDANCE_FETCHED)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> save(Attendance attendance) {
        attendance = attendanceRepository.save(attendance);
        if (attendance == null) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_ATTENDANCE_NOT_CREATED)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(attendance)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_ATTENDANCE_CREATED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(Attendance attendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendance.getAttendanceId());
        if (optionalAttendance.isPresent()) {
            Attendance updateAttendance = optionalAttendance.get();
            updateAttendance.setAttendanceIsPresent(attendance.getAttendanceIsPresent());
            updateAttendance.setAttendanceMeetingId(attendance.getAttendanceMeetingId());
            updateAttendance.setAttendanceUserId(attendance.getAttendanceUserId());
            updateAttendance.setAttendanceUpdatedDateTime(attendance.getAttendanceUpdatedDateTime());
            attendanceRepository.save(updateAttendance);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalAttendance)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_ATTENDANCE_UPDATED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_ATTENDANCE_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> delete(Long attendanceId) {
        if (attendanceRepository.findById(attendanceId).isPresent()) {
            attendanceRepository.deleteById(attendanceId);
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_ATTENDANCE_DELETED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                .body(JsonResponse.builder()
                        .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_ATTENDANCE_FOUND)
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> findAllAttendanceByMeeting(Long attendanceId) {
        List<Attendance> attendanceList = attendanceRepository.findAllAttendanceIdByAttendanceMeetingId(attendanceId);
        if (attendanceList.isEmpty())
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_ATTENDANCE_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());

        return ResponseEntity.status((HttpStatus.OK))
                .body(JsonResponse.builder()
                        .data(attendanceList)
                        .message(StringConstants.REQUEST_SUCCESS_MESSAGE_ATTENDANCE_FETCHED)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @Override
    public ResponseEntity<Object> getAllVisitorByMeeting(Long meetingId) {
        Optional<Role> role = roleRepository.findByRoleName(RoleEnum.VISITOR);
        if (!role.isPresent()) {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body(JsonResponse.builder()
                            .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_ATTENDANCE_FOUND)
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());
        } else {
            List<Attendance> optionalAttendance = attendanceRepository.findAllByUser_Role_RoleIdAndAttendanceMeetingId(role.get().getRoleId(), meetingId);
            if (optionalAttendance.isEmpty())
                return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                        .body(JsonResponse.builder()
                                .message(StringConstants.REQUEST_FAILURE_MESSAGE_NO_ATTENDANCE_FOUND)
                                .status(HttpStatus.BAD_REQUEST)
                                .statusCode(HttpStatus.BAD_REQUEST.value())
                                .build());
            return ResponseEntity.status((HttpStatus.OK))
                    .body(JsonResponse.builder()
                            .data(optionalAttendance)
                            .message(StringConstants.REQUEST_SUCCESS_MESSAGE_ATTENDANCE_FETCHED)
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
    }
}
