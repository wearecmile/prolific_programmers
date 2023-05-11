package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findAllAttendanceIdByAttendanceMeetingId(Long meetingId);

    List<Attendance> findAllByUser_Role_RoleIdAndAttendanceMeetingId(Long roleId, Long attendanceMeetingId);

}
