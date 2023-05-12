package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.Role;
import com.cmile.meetmate.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleEnum roleName);
}
