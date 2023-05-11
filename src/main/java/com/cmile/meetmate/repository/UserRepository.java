package com.cmile.meetmate.repository;

import com.cmile.meetmate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAllUserIdByUserRole(Long userRole);
}
