package com.ansari.service;

import com.ansari.domain.AccountStatus;
import com.ansari.exception.SellerException;
import com.ansari.model.Seller;
import java.util.List;

public interface SellerService {
    Seller getSellerProfile(String jwt) throws SellerException;
    Seller createSeller(Seller seller) throws SellerException;
    Seller getSellerById(Long id) throws SellerException;
    Seller getSellerByEmail(String email) throws SellerException;
    List<Seller> getAllSellers(AccountStatus status);
    Seller updateSeller(Long id, Seller seller) throws SellerException;
    void deleteSeller(Long id) throws SellerException;
    Seller verifyEmail(String email,String otp) throws SellerException;

    Seller updateSellerAccountStatus(Long sellerId, AccountStatus status) throws SellerException;
}
