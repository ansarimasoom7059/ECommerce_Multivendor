package com.ansari.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ansari.domain.USER_ROLE;
import com.ansari.model.Seller;
import com.ansari.repository.SellerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ansari.model.User;
import com.ansari.repository.UserRepository;

@Service
public class CustomeUserServiceImplementation implements UserDetailsService {

	private final UserRepository userRepository;
	private final SellerRepository sellerRepository;
	private static final String SELLER_PREFIX = "seller_";

	public CustomeUserServiceImplementation(UserRepository userRepository, SellerRepository sellerRepository) {
		this.userRepository = userRepository;
		this.sellerRepository = sellerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.startsWith(SELLER_PREFIX)) {
			// Remove prefix to get the actual username/email
			String actualUsername = username.substring(SELLER_PREFIX.length());
			Seller seller = sellerRepository.findByEmail(actualUsername);
			if (seller != null) {
				return buildUserDetails(seller.getEmail(), seller.getPassword(), seller.getRole());
			}
		} else {
			User user = userRepository.findByEmail(username);
			if (user != null) {
				return buildUserDetails(user.getEmail(), user.getPassword(), user.getRole());
			}
		}

		throw new UsernameNotFoundException("User or Seller not found with email - " + username);
	}

	private UserDetails buildUserDetails(String email, String password, USER_ROLE role) {
		if (role == null) role = USER_ROLE.ROLE_CUSTOMER;

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.toString()));

		return new org.springframework.security.core.userdetails.User(email, password, authorities);
	}
}
