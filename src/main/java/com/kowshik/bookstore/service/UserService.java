package com.kowshik.bookstore.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kowshik.bookstore.dto.UserRegistrationDto;
import com.kowshik.bookstore.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

}
