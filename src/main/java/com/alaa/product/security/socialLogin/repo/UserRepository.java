package com.alaa.product.security.socialLogin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alaa.product.security.socialLogin.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(final String username);

}