package com.ansari.service;

import com.ansari.exception.SellerException;
import com.ansari.exception.UserException;
import com.ansari.request.LoginRequest;
import com.ansari.request.SignupRequest;
import com.ansari.response.AuthResponse;
import jakarta.mail.MessagingException;

public interface AuthService {

    void sentLoginOtp(String email) throws UserException, MessagingException;
    String createUser(SignupRequest req) throws SellerException;
    AuthResponse signin(LoginRequest req) throws SellerException;

}
