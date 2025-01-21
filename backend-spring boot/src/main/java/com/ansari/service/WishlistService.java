package com.ansari.service;


import com.ansari.exception.WishlistNotFoundException;
import com.ansari.model.Product;
import com.ansari.model.User;
import com.ansari.model.Wishlist;

public interface WishlistService {

    Wishlist createWishlist(User user);

    Wishlist getWishlistByUserId(User user);

    Wishlist addProductToWishlist(User user, Product product) throws WishlistNotFoundException;

}

