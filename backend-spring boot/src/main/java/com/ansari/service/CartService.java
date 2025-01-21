package com.ansari.service;

import com.ansari.exception.ProductException;
import com.ansari.model.Cart;
import com.ansari.model.CartItem;
import com.ansari.model.Product;
import com.ansari.model.User;

public interface CartService {
	
	public CartItem addCartItem(User user,
								Product product,
								String size,
								int quantity) throws ProductException;
	
	public Cart findUserCart(User user);

}
