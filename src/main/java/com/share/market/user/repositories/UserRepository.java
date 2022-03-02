package com.share.market.user.repositories;

import com.share.market.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String userName);
}
