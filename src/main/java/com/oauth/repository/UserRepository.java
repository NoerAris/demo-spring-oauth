package com.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oauth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("from User x where x.username = ?1 and x.active = '1'")
    User findOneByUsername(String username);
}
