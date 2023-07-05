package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.User;
import com.cmile.meetmate.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllUserIdByUserRole(Long userRole);

    List<User> findAllByRole_RoleName(RoleEnum roleName);

    Optional<User> findByUserContact(String userContact);
}
