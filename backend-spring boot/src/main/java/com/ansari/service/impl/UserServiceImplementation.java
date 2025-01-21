package com.ansari.service.impl;


import com.ansari.exception.UserException;
import com.ansari.service.UserService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ansari.config.JwtProvider;
import com.ansari.model.User;
import com.ansari.repository.PasswordResetTokenRepository;
import com.ansari.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {


	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	private PasswordEncoder passwordEncoder;
	private PasswordResetTokenRepository passwordResetTokenRepository;
	private JavaMailSender javaMailSender;
	
	public UserServiceImplementation(
			UserRepository userRepository,
			JwtProvider jwtProvider,
			PasswordEncoder passwordEncoder,
			PasswordResetTokenRepository passwordResetTokenRepository,
			JavaMailSender javaMailSender) {
		
		this.userRepository=userRepository;
		this.jwtProvider=jwtProvider;
		this.passwordEncoder=passwordEncoder;
		this.passwordResetTokenRepository=passwordResetTokenRepository;
		this.javaMailSender=javaMailSender;
		
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email=jwtProvider.getEmailFromJwtToken(jwt);
		
		
		User user = userRepository.findByEmail(email);
		
		if(user==null) {
			throw new UserException("user not exist with email "+email);
		}
		return user;
	}



	
	@Override
	public User findUserByEmail(String username) throws UserException {
		
		User user=userRepository.findByEmail(username);
		
		if(user!=null) {
			
			return user;
		}
		
		throw new UserException("user not exist with username "+username);
	}



}
