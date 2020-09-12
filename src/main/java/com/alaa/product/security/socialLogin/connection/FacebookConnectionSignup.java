package com.alaa.product.security.socialLogin.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;
import com.alaa.product.security.socialLogin.entity.User;
import com.alaa.product.security.socialLogin.repo.UserRepository;
import java.util.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

	ViewControllerRegistry registry;
	
    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        final User user = new User();
        user.setUsername(connection.getDisplayName());
        String userId = connection.getKey().toString().substring(9);
        long userIdToLong= Long.parseLong(userId);
        user.setUserId(userIdToLong);
        user.setPassword("uihuihui");
        user.setImgUrl(connection.getImageUrl());
        boolean exists = userRepository.existsById(userIdToLong);
        if(exists==true) {
            registry.addViewController("/api/v1/products");
        }
        userRepository.save(user);
        return user.getUsername();
    }

}
 



