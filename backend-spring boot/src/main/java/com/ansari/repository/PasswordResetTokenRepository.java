package com.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
