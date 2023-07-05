package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.Group;
import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.entity.UserGroup;
import com.cmile.meetmate.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

    @Query(value = "select ug.group from UserGroup ug where ug.ugUserId=:userId")
    List<Group> findByUserId(Long userId);

    @Query(value = "select ug.user from UserGroup ug where ug.ugGroupId=:groupId")
    List<User> findByGroupId(Long groupId);

    UserGroup findByUgUserIdAndUgGroupId(Long userId, Long groupId);

//    List<UserGroup> findAllByUgUserId(Long ugUserId);

//    List<UserGroup> findAllByUgGroupId(Long ugGroupsId);

    List<UserGroup> findAllByUgGroupIdAndUgRoleName(Long ugGroupsId, RoleEnum ugRoleName);
}