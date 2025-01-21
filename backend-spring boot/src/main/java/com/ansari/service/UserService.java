package com.ansari.service;

import com.ansari.exception.UserException;
import com.ansari.model.User;

public interface UserService {

	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public User findUserByEmail(String email) throws UserException;


}
