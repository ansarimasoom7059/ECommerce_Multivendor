package com.ansari.response;

import com.ansari.dto.OrderHistory;
import com.ansari.model.Cart;
import com.ansari.model.Product;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionResponse {
    private String functionName;
    private Cart userCart;
    private OrderHistory orderHistory;
    private Product product;
}
